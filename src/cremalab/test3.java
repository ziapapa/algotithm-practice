package cremalab;
import java.util.Stack;

public class test3 {

	public static void main(String[] args) {

		String pre_exp = "+1*23";
		System.out.println("Postfix : " + preToPost(pre_exp));

	}

	static boolean isOperator(char x) {
		switch (x) {
		case '+':
		case '-':
		case '/':
		case '*':
			return true;
		}
		return false;
	}

	// Convert prefix to Postfix expression
	static String preToPost(String pre_exp) {

		Stack<String> s = new Stack<String>();

		// length of expression
		int length = pre_exp.length();

		// reading from right to left
		for (int i = length - 1; i >= 0; i--) {

			// check if symbol is operator
			if (isOperator(pre_exp.charAt(i))) {

				// pop two operands from stack
				String op1 = s.peek();
				s.pop();
				String op2 = s.peek();
				s.pop();

				// concat the operands and operator
				//String temp = op1 + op2 + pre_exp.charAt(i);

				StringBuilder temp = new StringBuilder();
				temp.append(op1);
				temp.append(op2);
				temp.append(pre_exp.charAt(i));
				
				System.out.println(temp.toString());
				// Push String temp back to stack
				s.push(temp.toString());
			}

			// if symbol is an operand
			else {
				// push the operand to the stack
				System.out.println(pre_exp.charAt(i) + "");
				s.push(pre_exp.charAt(i) + "");
			}
		}

		// stack contains only the Postfix expression
		return s.peek();
	}
}
