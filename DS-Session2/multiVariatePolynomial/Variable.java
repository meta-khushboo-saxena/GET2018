package multiVariatePolynomial;

/**
 * Class to create the variable
 */
public class Variable {
	private char variableName;
	private int power;

	/**
	 * Constructor to initialize the variable and power
	 * @param variableSymbol
	 * @param power
	 */
	public Variable(char variableSymbol, int power) {
		this.variableName = variableSymbol;
		this.power = power;
	}
	
	/**
	 * Function to get the variable
	 * @return the variableSymbol
	 */
	public char getVariableName() {
		return variableName;
	}
	
	/**
	 * Function to get the power of the variable
	 * @return the power
	 */
	public int getPower() {
		return power;
	}
}
