package SCF_Session5_Recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {

	Search search = new Search();
	
	@Test
	public void testBinarySearch1() {
		int result = search.binary(new int[] { 5, 7, 9, 14, 25 }, 9);
		assertEquals(2, result);
	}

	@Test
	public void testBinarySearch2() {
		int result = search.binary(new int[] { 1, 4, 5, 7, 8, 9 }, 8);
		assertNotEquals(3, result);
	}

	@Test
	public void testBinarySearch3() {
		int result = search.binary(new int[] { 1, 4, 6, 7, 12 }, 40);
		assertEquals(-1, result);
	}

	@Test
	public void testLinearSearch1() {
		int result = search.linear(new int[] { 1, 2, 3, 4, 5, 6 }, 4);
		assertEquals(3, result);
	}

	@Test
	public void testLinearSearch2() {
		int result = search.linear(new int[] { 1, 2, 3, 4, 5, 6 }, 4);
		assertNotEquals(7, result);
	}
	
	@Test
	public void testLinearSearch3() {
		int result = search.linear(new int[] { 1, 4, 6, 7, 12 }, 40);
		assertEquals(-1, result);
	}
}
