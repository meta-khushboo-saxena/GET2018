package multiVariatePolynomial;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiVariatePolynomialTest {
	MultiVariatePolynomial multiVariatePolynomial = new MultiVariatePolynomial();

	@Test
	public void testAddTerm1() {
		Variable variable1 = new Variable('a', 3);
		Variable variable2 = new Variable('b', 5);
		Variable variable3 = new Variable('c', 7);
		Variable variable4 = new Variable('d', 3);
		Variable variable5 = new Variable('e', 5);
		Variable variable6 = new Variable('f', 5);

		Term term1 = new Term(4);
		term1.addVariable(variable1);
		term1.addVariable(variable4);
		term1.addVariable(variable3);

		Term term2 = new Term(5);
		term2.addVariable(variable2);
		term2.addVariable(variable4);

		Term term3 = new Term(6);
		term3.addVariable(variable5);
		term3.addVariable(variable6);

		Term term4 = new Term(4);

		multiVariatePolynomial.addTerm(term1);
		multiVariatePolynomial.addTerm(term2);
		multiVariatePolynomial.addTerm(term3);
		multiVariatePolynomial.addTerm(term4);
		String actualResult = multiVariatePolynomial.getPolyNomial();
		String expectedResult = "(4 a^3 d^3 c^7 ) + (5 b^5 d^3 ) + (6 e^5 f^5 ) + (4 ) + ";
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testAddTerm2() {
		Variable variable1 = new Variable('a', 3);
		Variable variable2 = new Variable('b', 3);
		Variable variable3 = new Variable('c', 3);
		Variable variable4 = new Variable('a', 1);
		Variable variable5 = new Variable('b', 1);
		Variable variable6 = new Variable('c', 1);

		Term term1 = new Term(1);
		term1.addVariable(variable1);

		Term term2 = new Term(1);
		term2.addVariable(variable2);

		Term term3 = new Term(1);
		term3.addVariable(variable3);

		Term term4 = new Term(3);
		term4.addVariable(variable4);
		term4.addVariable(variable5);

		Term term5 = new Term(5);
		term5.addVariable(variable4);
		term5.addVariable(variable6);

		Term term6 = new Term(6);
		term6.addVariable(variable5);
		term6.addVariable(variable6);

		multiVariatePolynomial.addTerm(term1);
		multiVariatePolynomial.addTerm(term2);
		multiVariatePolynomial.addTerm(term3);
		multiVariatePolynomial.addTerm(term4);
		multiVariatePolynomial.addTerm(term5);
		multiVariatePolynomial.addTerm(term6);

		String actualResult = multiVariatePolynomial.getPolyNomial();
		String expectedResult = "(1 a^3 ) + (1 b^3 ) + (1 c^3 ) + (3 a^1 b^1 ) + (5 a^1 c^1 ) + (6 b^1 c^1 ) + ";
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testRemoveTerm() {
		Variable variable1 = new Variable('a', 3);
		Variable variable2 = new Variable('b', 3);

		Term term1 = new Term(4);
		term1.addVariable(variable1);

		Term term2 = new Term(5);
		term2.addVariable(variable2);

		multiVariatePolynomial.addTerm(term1);
		multiVariatePolynomial.addTerm(term2);

		multiVariatePolynomial.removeTerm(term2);

		String actualResult = multiVariatePolynomial.getPolyNomial();
		String expectedResult = "(4 a^3 ) + ";
		assertEquals(expectedResult, actualResult);
	}
}
