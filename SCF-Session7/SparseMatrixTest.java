package SCF_Session7_Invariant;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class SparseMatrixTest {

	@Test
	public void testCheckTranspose1() {
		SparseMatrix matrix = new SparseMatrix(new int[][] { { 0, 2, 0 },
				{ 1, 1, 0 }, { 0, 0, 0 } });
		int result[][] = matrix.transpose();
		assertArrayEquals(
				new int[][] { { 1, 0, 2 }, { 0, 1, 1 }, { 1, 1, 1 } }, result);
	}

	@Test
	public void testCheckSymmetry1() {
		SparseMatrix matrix = new SparseMatrix(
				new int[][] { { 0, 2 }, { 2, 0 } });
		boolean result = matrix.checkSymmetrical();
		Assert.assertEquals(true, result);
	}

	@Test
	public void testCheckSymmetry2() {
		SparseMatrix matrix = new SparseMatrix(new int[][] { { 0, 0, 2 },
				{ 4, 0, 3 }, { 0, 2, 0 } });
		boolean result = matrix.checkSymmetrical();
		Assert.assertEquals(false, result);
	}

	@Test
	public void testCheckAddition1() {
		SparseMatrix matrix1 = new SparseMatrix(new int[][] { { 0, 0, 2 },
				{ 4, 0, 3 }, { 0, 2, 0 } });
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 0, 2, 0 },
				{ 1, 1, 0 }, { 0, 0, 0 } });
		int result[][] = matrix1.add(matrix2);
		int expected[][] = { { 0, 2, 2 }, { 5, 1, 3 }, { 0, 2, 0 } };
		Assert.assertArrayEquals(expected, result);

	}

	@Test
	public void testCheckAddition2() {
		SparseMatrix matrix1 = new SparseMatrix(new int[][] { { 1, 0, 0 },
				{ 0, 0, 3 }, { 5, 0, 0 } });
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 2, 0, 7 },
				{ 4, 0, 0 }, { 9, 0, 4 } });
		int result[][] = matrix1.add(matrix2);
		int expected[][] = { { 3, 0, 7 }, { 4, 0, 3 }, { 14, 0, 4 } };
		assertArrayEquals(expected, result);
	}

	@Test
	public void testCheckMultiply1() {
		SparseMatrix matrix1 = new SparseMatrix(new int[][] { { 1, 0, 0 },
				{ 1, 2, 0 }, { 0, 0, 3 } });
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 2, 0 },
				{ 1, 0 }, { 0, 3 } });
		int result[][] = matrix1.multiply(matrix2);
		int expected[][] = { { 2, 0 }, { 4, 0 }, { 0, 9 } };
		Assert.assertArrayEquals(expected, result);

	}

	@Test
	public void testCheckMultiply2() {
		SparseMatrix matrix1 = new SparseMatrix(new int[][] { { 1, 2, 0, 0 },
				{ 5, 0, 0, 1 }, { 2, 0, 0, 0 } });
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 0, 0, 5 },
				{ 1, 2, 0 }, { 1, 0, 3 }, { 0, 0, 0 } });
		int result[][] = matrix1.multiply(matrix2);
		int expected[][] = { { 2, 4, 5 }, { 0, 0, 25 }, { 0, 0, 10 } };
		assertArrayEquals(expected, result);
	}
}