package postfix;
/**
 * A postfix arithmetic expression evaluator.
 * This is the driver.
 * Currently only evaluates integer arithmetic.
 * 
 * @author Connor Hollis
 *
 */
public class Evaluator {

	public Evaluator(){}
	
	public int intEval(String expr) throws IllegalExpressionException{
		Stack<Integer> nums = new Stack<Integer>();
		for(int i=0; i<expr.length();i++){
			char ch = expr.charAt(i);
			if(ch==' '){
				continue;
			}
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
				int second = nums.pop();
				int first = nums.pop();
				switch(ch){
				case '+': nums.push(first+second); break;
				case '-': nums.push(first-second); break;
				case '*': nums.push(first*second); break;
				case '/': nums.push(first/second); break;
				}
			}
			else if(Character.isDigit(ch)){
				nums.push(Character.digit(ch, 10));
			}
			else{
				throw new IllegalExpressionException();
			}
		}
		if(nums.size()!=1){
			throw new IllegalExpressionException();
		}
		else{
			return nums.pop();
		}
	}
}



