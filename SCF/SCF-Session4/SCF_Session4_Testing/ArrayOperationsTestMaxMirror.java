package SCF_Session4_Testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayOperationsTestMaxMirror {

	ArrayOperations operations = new ArrayOperations();

	@Test
	public void test1() {
		int result1 = operations
				.maxMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 });
		assertEquals(3, result1);

	}

	@Test
	public void test2() {
		int result2 = operations.maxMirror(new int[] { 7, 1, 4, 9, 7, 4, 1 });
		assertEquals(2, result2);
	}

	@Test
	public void test3() {
		int result3 = operations.maxMirror(new int[] { 1, 2, 1, 4 });
		assertEquals(3, result3);
	}

	@Test
	public void test4() {
		int result4 = operations.maxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 });
		assertEquals(7, result4);
	}

	@Test
	public void test5() {
		int result4 = operations.maxMirror(new int[] { 1, 2, 3, 4, 5 });
		assertEquals(1, result4);
	}
}
