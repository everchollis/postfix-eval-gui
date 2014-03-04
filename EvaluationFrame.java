package postfix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EvaluationFrame extends JFrame implements ActionListener{
	JPanel pane = new JPanel();
	JTextField input = new JTextField(20);
	JTextArea output = new JTextArea(200,200);
	JButton submit = new JButton("Evaluate on Integers");
	JButton submit2 = new JButton("Evaluate on Doubles");
	JTextField doubleInput = new JTextField(20);
	Evaluator driver = new Evaluator();
	
	public EvaluationFrame(){
		super("PostFix Evaluator");
		setBounds(500,200,500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		con.add(pane);
		pane.add(input);
		pane.add(submit);
		pane.add(doubleInput);
		pane.add(submit2);
		output.setColumns(20);
        output.setLineWrap(true);
        output.setRows(5);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        JScrollPane scrollPanel = new JScrollPane(output);
        pane.add(scrollPanel);
		submit.addActionListener(this);
		submit2.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		String expr;
		if(source == submit){
			try{
				expr = input.getText();
				int result = driver.intEval(expr);
				output.append("Evaluated Postfix: " + result + "\n");
			}
			catch(IllegalExpressionException e){
				output.append("Illegal Expression. Try again. \nRemember:\n Integers Only.\nDon't divide by 0.\n");
			}
		}
		if(source == submit2){
			try{
				expr=doubleInput.getText();
				double result = driver.doubleEval(expr);
				output.append("Evaluated Postfix: " + result + "\n");
			}
			catch(IllegalExpressionException e){
				output.append("Illegal Expression. Try Again. \n");
			}
		}
	}
	
}
