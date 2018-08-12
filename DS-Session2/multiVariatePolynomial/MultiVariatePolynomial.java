package multiVariatePolynomial;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to create the multivariate polynomial
 */
public class MultiVariatePolynomial {

	private List<Term> listOfTerms;

	/**
	 * Function to initialize the list of terms
	 */
	public MultiVariatePolynomial() {
		listOfTerms = new ArrayList<Term>();
	}

	/**
	 * Function to add term to the polynomial
	 * 
	 * @param term
	 * @return list of terms
	 */
	public boolean addTerm(Term term) {
		return listOfTerms.add(term);
	}

	/**
	 * Function to remove terms from the polynomial
	 * 
	 * @param term : contain the term to be removed
	 * @return the list of terms
	 */
	public boolean removeTerm(Term term) {
		return listOfTerms.remove(term);
	}

	/**
	 * Function to get the list of terms
	 * 
	 * @return list of terms
	 */
	public List<Term> getPolynomialList() {
		return this.listOfTerms;
	}

	/**
	 * creating the polynomial string by adding all the terms in the list
	 * 
	 * @return the polynomial
	 */
	public String getPolyNomial() {
		String polynomial = "";
		for (Term term : listOfTerms) {
			polynomial = polynomial + term.getTerm();
		}
		return polynomial;
	}
}
