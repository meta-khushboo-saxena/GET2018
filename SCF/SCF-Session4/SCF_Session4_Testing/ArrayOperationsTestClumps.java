package SCF_Session4_Testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayOperationsTestClumps {

	ArrayOperations operations = new ArrayOperations();

	@Test
	public void test1() {
		int result1 = operations.clumps(new int[] { 1, 2, 2, 3, 4, 4 });
		assertEquals(2, result1);

	}

	@Test
	public void test2() {
		int result2 = operations.clumps(new int[] { 1, 1, 2, 1, 1 });
		assertEquals(2, result2);
	}

	@Test
	public void test3() {
		int result3 = operations.clumps(new int[] { 1, 1, 1, 1, 1 });
		assertEquals(1, result3);
	}

	@Test
	public void test4() {
		int result4 = operations.clumps(new int[] { 1, 2, 3, 4, 5 });
		assertEquals(0, result4);
	}

}
