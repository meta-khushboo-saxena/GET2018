package InfixToPostfix;

import Stack.Stack;
import Stack.StackUsingLinkList;

/**
 * Class to convert Infix Expression to Postfix Expression
 */
public class InfixToPostfix {

	Stack<String> stackOfOperators = new StackUsingLinkList<String>();

	String infixExpression;

	// Constructor to initialize the expression
	public InfixToPostfix(String infixExpression) {

		this.infixExpression = infixExpression;

	}

	/**
	 * Function to check for the validity of the expression
	 * 
	 * @param expression
	 * @return
	 */
	public boolean checkValidity(String expression) {

		int i = 0, countOperator = 0, countDigits = 0, countLeftParenthesis = 0, countRightParenthesis = 0;
		String[] tokens = expression.split(" ");
		while (i < tokens.length) {

			if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])
					|| "%".equals(tokens[i]) || ">".equals(tokens[i]) || "<".equals(tokens[i]) || ">=".equals(tokens[i])
					|| "<=".equals(tokens[i]) || "==".equals(tokens[i]) || "!=".equals(tokens[i]) || "&&".equals(tokens[i])
					|| "||".equals(tokens[i])) {

				countOperator++;

			} else if ("(".equals(tokens[i])) {

				countLeftParenthesis++;

			} else if (")".equals(tokens[i])) {

				countRightParenthesis++;

			} else {

				countDigits++;
			}

			i++;
		}
		if ((countOperator >= countDigits) || (countLeftParenthesis != countRightParenthesis)) {
			return true;
		}
		return false;
	}

	/**
	 * Function to check the precedence of the operator
	 * 
	 * @param operator
	 * @return precedence in form of int
	 */
	public int checkPrecedence(String operator) {
		int priority = 0;
		switch (operator) {
		case "(":
		case ")":
		case "[":
		case "]":
			priority = 7;
			break;

		case "*":
		case "/":
		case "%":
			priority = 1;
			break;

		case "+":
		case "-":
			priority = 2;
			break;

		case "<":
		case ">":
		case "<=":
		case ">=":
			priority = 3;
			break;

		case "==":
		case "!=":
			priority = 4;
			break;

		case "&&":
			priority = 5;
			break;
		case "||":
			priority = 6;
			break;
		}

		return priority;
	}

	/**
	 * Function to convert infix to postfix expression
	 * 
	 * @return
	 */
	public String convertInfixToPostfix() {
		String resultingPostfixExpression = "";

		if (checkValidity(this.infixExpression)) {
			throw new AssertionError("Invalid Postfix equation");
		}

		String tokens[] = this.infixExpression.split(" ");
		int index = 0;

		while (index < tokens.length) {

			// Check if it is alphabet
			if (tokens[index].matches("[A-Z]+")) {

				resultingPostfixExpression += tokens[index] + " ";

				// check if it is numeric
			} else if (tokens[index].matches("[0-9]+")) {

				resultingPostfixExpression += tokens[index] + " ";

				// if ( is found push into stack
			} else if ("(".equals(tokens[index])) {

				stackOfOperators.push(tokens[index]);

				// if ) found pop till ( is found
			} else if (")".equals(tokens[index])) {

				while (!("(").equals(stackOfOperators.peek()) && !stackOfOperators.isEmpty()) {

					resultingPostfixExpression += stackOfOperators.pop() + " ";

				}
				if (!stackOfOperators.isEmpty() && !("(").equals(stackOfOperators.peek())) {
					return "invalid";
				}

				stackOfOperators.pop();

			} else {

				if (!stackOfOperators.isEmpty()
						&& this.checkPrecedence(tokens[index]) >= this.checkPrecedence(stackOfOperators.peek())) {

					resultingPostfixExpression += stackOfOperators.pop() + " ";

				}
				stackOfOperators.push(tokens[index]);

			}

			index++;
		}
		// pop rest of the elements from stack and append in string
		while (!stackOfOperators.isEmpty()) {

			resultingPostfixExpression += stackOfOperators.pop() + " ";

		}
		return resultingPostfixExpression;
	}

	public static void main(String args[]) {
		InfixToPostfix expression = new InfixToPostfix("A + ( B * C - ( D / E - F ) * G ) * H");

		System.out.println(expression.convertInfixToPostfix());

	}
}
