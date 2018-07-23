package SCF_Session4_Testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayOperationsTestSplitArray {

	ArrayOperations operations = new ArrayOperations();

	@Test
	public void test1() {
		int result1 = operations.splitArray(new int[] { 1, 1, 1, 2, 1 });
		assertEquals(3, result1);

	}

	@Test
	public void test2() {
		int result2 = operations.splitArray(new int[] { 2, 1, 1, 2, 1 });
		assertEquals(-1, result2);
	}

	@Test
	public void test3() {
		int result3 = operations.splitArray(new int[] { 10, 10 });
		assertEquals(1, result3);
	}

}
