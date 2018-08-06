package InfixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

	@Test(expected = AssertionError.class)
	public void testAssertionsEnabled() {
		InfixToPostfix expression = new InfixToPostfix("23 * ( 2 + 1 - 2 ) 5 - / + 3 / 1");
		String result = expression.convertInfixToPostfix();
	}

	// Positive Test case
	@Test
	public void testinfixToPostfix1() {
		InfixToPostfix expression = new InfixToPostfix("( A + B )");
		String result = expression.convertInfixToPostfix();
		assertEquals("A B + ", result);
	}

	@Test
	public void testinfixToPostfix2() {
		InfixToPostfix expression = new InfixToPostfix("A + ( B * C - ( D / E - F ) * G ) * H");
		String result = expression.convertInfixToPostfix();
		assertEquals("A B C * D E / F - G * - H * + ", result);
	}

	@Test
	public void testInfixToPostfix3() {
		InfixToPostfix expression = new InfixToPostfix("23 * ( 2 + 1 - 2 ) + 3 / 1");
		String result = expression.convertInfixToPostfix();
		assertEquals("23 2 1 + 2 - * 3 1 / + ", result);
	}

}