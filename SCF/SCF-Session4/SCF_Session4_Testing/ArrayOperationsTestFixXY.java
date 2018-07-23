package SCF_Session4_Testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayOperationsTestFixXY {
	ArrayOperations operations = new ArrayOperations();

	@Test
	public void test1() {
		int result1[] = operations.fixXY(new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5);
		int expected[] = { 9, 4, 5, 4, 5, 9 };
		assertArrayEquals(expected, result1);

	}

	@Test
	public void test2() {
		int result1[] = operations.fixXY(new int[] { 1, 4, 1, 5 }, 4, 5);
		int expected[] = { 1, 4, 5, 1 };
		assertArrayEquals(expected, result1);
	}

	@Test
	public void test3() {
		int result1[] = operations.fixXY(new int[] { 1, 4, 1, 5, 5, 4, 1 }, 4,
				5);
		int expected[] = { 1, 4, 5, 1, 1, 4, 5 };
		assertArrayEquals(expected, result1);
	}

}
