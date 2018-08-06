package PostfixEvaluation;

import Stack.StackUsingLinkList;

public class PostfixEvaluate {
	StackUsingLinkList<Integer> stack = new StackUsingLinkList<Integer>();
	int flag = 0;

	/**
	 * Function to check for the operator
	 * 
	 * @param operator
	 * @return
	 */
	public boolean checkOperator(String operator) {
		boolean flag = false;
		if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("^")) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to check if the expression is valid or not
	 * 
	 * @param character
	 * @return
	 */
	public boolean checkExpression(String character[]) {
		int index = 0;
		boolean flag = false;
		int countDigit = 0, countOperator = 0;

		// check if the string is digit or operator
		while (index < character.length) {

			if (character[index].matches("[0-9]+")) {
				countDigit++;
			} else if (checkOperator(character[index])) {
				countOperator++;
			} else {
				System.out.println("!!Not a valid Expression!!");
				break;
			}
			index++;
		}

		// check if the count of operator is one less than count of digit
		if (countOperator == countDigit - 1) {
			flag = true;
		} else {
			System.out.println("!!Not a valid Expression!!");
		}
		return flag;
	}

	/**
	 * Function to evaluate the expression
	 * 
	 * @param expression
	 */
	public int evaluate(String expression) {
		String[] character = expression.split(" ");
		int index = 0, result = 0;

		// check the expression and if it is digit push it on the stack else if
		// it is operator evaluate
		if (checkExpression(character)) {
			while (index < character.length) {
				if (character[index].matches("[0-9]+")) {
					stack.push(Integer.parseInt(character[index]));
				} else if (stack.isEmpty()) {
					System.out.println("!!Invalid Expression!!");
					return result;
				} else {
					operate(character[index].charAt(0));
				}
				stack.show();
				index++;
			}
			result = stack.pop();
		}
		return result;
	}

	/**
	 * Function to perform the operations on the operand
	 * 
	 * @param operator
	 */
	public void operate(char operator) {
		int operand1 = 0, operand2 = 0, result = 0, index;
		operand1 = stack.pop();

		operand2 = stack.pop();

		switch (operator) {
		case '+': {
			result = operand2 + operand1;
			break;
		}
		case '-': {
			result = operand2 - operand1;
			break;
		}
		case '*': {
			result = operand2 * operand1;
			break;
		}
		case '/': {
			result = operand2 / operand1;
			break;
		}
		case '^': {
			for (index = 0, result = 1; index < operand1; index++) {
				result *= operand2;

			}
			break;
		}

		}
		stack.push(result);

	}

	/**
	 * main function of the class
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		PostfixEvaluate postfixEvaluate = new PostfixEvaluate();
		postfixEvaluate.evaluate("5 6 12 + * 9 3 / -");
	}
}
