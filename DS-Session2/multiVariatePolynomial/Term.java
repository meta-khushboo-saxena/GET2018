package multiVariatePolynomial;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to create the terms
 */
public class Term {
	private int coefficient;
	private List<Variable> listOfVariables;

	/**
	 * Constructor to initialize the coefficient and the list of variables
	 * 
	 * @param coefficient
	 */
	public Term(int coefficient) {
		this.coefficient = coefficient;
		listOfVariables = new ArrayList<Variable>();
	}

	/**
	 * Function to add the variable
	 * 
	 * @param variable
	 * @return
	 */
	public boolean addVariable(Variable variable) {
		return listOfVariables.add(variable);
	}

	/**
	 * Function to remove the variable
	 * 
	 * @param variable
	 * @return
	 */
	public boolean removeVariable(Variable variable) {
		return listOfVariables.remove(variable);
	}

	/**
	 * Function to get the complete term
	 * 
	 * @return the terms
	 */
	public String getTerm() {
		String termString = "(";
		termString = termString + coefficient + " ";
		for (Variable variable : listOfVariables) {
			termString = termString + variable.getVariableName() + "^"
					+ variable.getPower() + " ";
		}
		return termString + ") + ";
	}
}
