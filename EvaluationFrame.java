package postfix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EvaluationFrame extends JFrame implements ActionListener{
	JPanel pane = new JPanel();
	JTextField input = new JTextField(20);
	JTextArea output = new JTextArea(200,200);
	JButton submit = new JButton("Evaluate");
	Evaluator driver = new Evaluator();
	
	public EvaluationFrame(){
		super("PostFix Evaluator");
		setBounds(300,200,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		con.add(pane);
		pane.add(input);
		pane.add(submit);
		GridBagConstraints c = new GridBagConstraints();
		output.setColumns(20);
        output.setLineWrap(true);
        output.setRows(5);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        JScrollPane scrollPanel = new JScrollPane(output);
        pane.add(scrollPanel);
		submit.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		String expr = input.getText();
		if(source == submit){
			try{
				int result = driver.intEval(expr);
				output.append("Evaluated Postfix: " + result + "\n");
			}
			catch(IllegalExpressionException e){
				output.append("Illegal Expression. Try again. \n");
			}
		}
	}
	
}
