package SCF_Session7_Invariant;

public final class SparseMatrix {

	private int matrixArray[][];
	private int row;
	private int column;

	/**
	 * Constructor for storing the Sparse matrix in 2D array without non-zero
	 * elements
	 * 
	 * @param SparseMatrix
	 */
	public SparseMatrix(int sparseMatrix[][]) {
		this.row = sparseMatrix.length;
		this.column = sparseMatrix[0].length;
		int count = countElements(sparseMatrix);

		this.matrixArray = new int[count][3];
		int k = 0;
		for (int i = 0; i < sparseMatrix.length; i++) {
			for (int j = 0; j < sparseMatrix[0].length; j++) {
				if (sparseMatrix[i][j] != 0) {
					this.matrixArray[k][0] = i;
					this.matrixArray[k][1] = j;
					this.matrixArray[k][2] = sparseMatrix[i][j];
					k++;
				}
			}
		}
	}

	/**
	 * Helper function to check if two matrix are valid for addition
	 * 
	 * @param sparse2
	 * @return true or false
	 */
	private boolean checkForSquareMatrix(SparseMatrix sparse) {
		if (this.row != sparse.row || this.column != sparse.column) {
			return false;
		}
		return true;
	}

	/**
	 * Helper function for making deep copy
	 * 
	 * @param array
	 * @return array with deep copy
	 */
	private int[][] getDeepCopy(int array[][]) {
		int newArray[][] = new int[this.matrixArray.length][this.matrixArray[0].length];

		// Making a deep copy of new array references
		for (int row = 0; row < this.matrixArray.length; row++) {
			for (int column = 0; column < this.matrixArray[0].length; column++) {
				newArray[row][column] = this.matrixArray[row][column];
			}
		}
		return newArray;
	}

	/**
	 * Helper function to sort
	 * 
	 * @param array
	 * @return
	 */
	private int[][] sort(int array[][]) {
		for (int index = 0; index < array.length; index++) {
			for (int index2 = 0; index2 < (array.length - 1) - index; index2++) {
				if (array[index2][0] > array[index2 + 1][0]) {
					for (int index3 = 0; index3 < 3; index3++) {
						// swapping for row index2 and column index3
						int temp = array[index2][index3];
						array[index2][index3] = array[index2 + 1][index3];
						array[index2 + 1][index3] = temp;
					}
				}
				if (array[index2][0] == array[index2 + 1][0]
						&& array[index2][1] > array[index2 + 1][1]) {
					for (int index3 = 1; index3 < 3; index3++) {
						// swapping for row index2 and column index3
						int temp = array[index2][index3];
						array[index2][index3] = array[index2 + 1][index3];
						array[index2 + 1][index3] = temp;
					}
				}
			}
		}
		return array;
	}

	/**
	 * function to count the number of elements in the matrix
	 */
	public int countElements(int matrix[][]) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Function to transpose a matrix;
	 * 
	 * @return transpose[][];
	 */
	public int[][] transpose() {
		int temp;
		int transposeMatrix[][] = this.getDeepCopy(matrixArray);
		int k = 0;
		for (int i = 0; i < transposeMatrix.length; i++) {
			temp = transposeMatrix[i][0];
			transposeMatrix[i][0] = transposeMatrix[i][1];
			transposeMatrix[i][1] = temp;
			k++;
		}

		return transposeMatrix;
	}

	/**
	 * Function to check two sparse matrix are symmetrical or not
	 * 
	 * @return true or false
	 */
	public boolean checkSymmetrical() {
		boolean flag = true;
		int matrix[][], transpose[][];
		matrix = this.getDeepCopy(matrixArray);
		transpose = this.transpose();

		sort(transpose);

		// Here 0 and 1 denotes the fix row number and column number of sparse
		// matrix non-zero element
		for (int i = 0; i < transpose.length; i++) {
			if (matrix[i][0] != transpose[i][0]
					&& matrix[i][1] != transpose[i][1]) {
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * Addition of two Sparse Matrix
	 * 
	 * @param matrix2
	 * @return Add result in 2D array
	 */
	public int[][] add(SparseMatrix matrix2) {

		// If matrix is not a square matrix
		if (!this.checkForSquareMatrix(matrix2)) {
			throw new AssertionError("Not a square matrtix for addition");
		}

		int i = 0, j = 0, k = 0;
		int addition[][] = new int[this.matrixArray.length
				+ matrix2.matrixArray.length][matrixArray[0].length];

		while (i < this.matrixArray.length && j < matrix2.matrixArray.length) {

			// If matrix2 rows and column are smaller
			if (matrixArray[i][0] > matrix2.matrixArray[j][0]
					|| ((this.matrixArray[i][0] == matrix2.matrixArray[j][0]) && (this.matrixArray[i][1] > matrix2.matrixArray[j][1]))) {

				addition[k][0] = matrix2.matrixArray[j][0];
				addition[k][1] = matrix2.matrixArray[j][1];
				addition[k][2] = matrix2.matrixArray[j][2];
				j++;
				k++;
			}
			// If matrix2 rows and column are greater
			else if (matrixArray[i][0] < matrix2.matrixArray[j][0]
					|| ((this.matrixArray[i][0] == matrix2.matrixArray[j][0]) && (this.matrixArray[i][1] < matrix2.matrixArray[j][1]))) {

				addition[k][0] = this.matrixArray[i][0];
				addition[k][1] = this.matrixArray[i][1];
				addition[k][2] = this.matrixArray[i][2];
				i++;
				k++;
			}
			// if the rows and column are same add the values
			else {
				addition[k][0] = this.matrixArray[i][0];
				addition[k][1] = this.matrixArray[i][1];
				addition[k][2] = this.matrixArray[i][2]
						+ matrix2.matrixArray[j][2];
				i++;
				j++;
				k++;
			}

		}
		// Insert remaining elements of matrixArray
		while (i < this.matrixArray.length) {
			addition[k][0] = this.matrixArray[i][0];
			addition[k][1] = this.matrixArray[i][1];
			addition[k][2] = this.matrixArray[i][2];
			i++;
			k++;
		}
		// Insert remaining elements of matrix2
		while (j < matrix2.matrixArray.length) {
			addition[k][0] = matrix2.matrixArray[j][0];
			addition[k][1] = matrix2.matrixArray[j][1];
			addition[k][2] = matrix2.matrixArray[j][2];
			j++;
			k++;
		}

		int additionNew[][] = new int[this.row][this.column];

		for (i = 0; i < this.row; i++) {
			for (j = 0; j < this.column; j++) {
				additionNew[i][j] = 0;
			}
		}
		for (i = 0; i < k; i++) {
			additionNew[addition[i][0]][addition[i][1]] = addition[i][2];
		}
		return additionNew;
	}

	/**
	 * Function to multiply two sparse matrix
	 * 
	 * @param matrix2
	 * @return multiplication of matrix
	 */
	public int[][] multiply(SparseMatrix matrix2) {
		int k = 0;
		int matrix[][] = matrix2.matrixArray;
		int multiply[][] = new int[this.matrixArray.length
				* matrix2.matrixArray.length][3];
		if (this.column != matrix2.row) {

			throw new AssertionError("Invalid matrix for multiplication!!");

		}
		matrix = matrix2.transpose();
		sort(matrix);
		int i, j;
		for (i = 0; i < matrixArray.length;) {
			int row = matrixArray[i][0];
			for (j = 0; j < matrix.length;) {
				int column = matrix[j][0];

				// temporary variable created to add all
				// multiplied values to obtain current
				// element of result matrix
				int tempIndex1 = i;
				int tempIndex2 = j;

				int sum = 0;

				// iterate over all elements with
				// same row and col value
				// to calculate result
				while (tempIndex1 < matrixArray.length
						&& matrixArray[tempIndex1][0] == row
						&& tempIndex2 < matrix.length
						&& matrix[tempIndex2][0] == column) {

					if (matrixArray[tempIndex1][1] < matrix[tempIndex2][1])

						// skip Index1
						tempIndex1++;

					else if (matrixArray[tempIndex1][1] > matrix[tempIndex2][1])

						// skip Index2
						tempIndex2++;
					else

						// same column, so multiply and increment
						sum += matrixArray[tempIndex1++][2]
								* matrix[tempIndex2++][2];
				}
				if (sum != 0) {
					// if sum is not 0 then insert it in the matrix

					multiply[k][0] = row;
					multiply[k][1] = column;
					multiply[k][2] = sum;
					k++;
				}

				while (j < matrix.length && matrix[j][0] == column)

					// jump to next column
					j++;
			}
			while (i < matrixArray.length && matrixArray[i][0] == row)

				// jump to next row
				i++;
		}

		int multiplication[][] = new int[this.row][matrix2.column];

		for (i = 0; i < this.row; i++) {
			for (j = 0; j < matrix2.column; j++) {
				multiplication[i][j] = 0;
			}
		}
		for (i = 0; i < k; i++) {
			multiplication[multiply[i][0]][multiply[i][1]] = multiply[i][2];
		}
		return multiplication;
	}

	public static void main(String args[]) {

		SparseMatrix matrix1 = new SparseMatrix(new int[][] { { 1, 0, 0 },
				{ 1, 2, 0 }, { 0, 0, 3 } });
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 2, 0 },
				{ 1, 0 }, { 0, 3 } });
		SparseMatrix matrix3 = new SparseMatrix(new int[][] { { 0, 0, 2 },
				{ 4, 0, 3 }, { 0, 2, 0 } });
		SparseMatrix matrix4 = new SparseMatrix(new int[][] { { 0, 2, 0 },
				{ 1, 1, 0 }, { 0, 0, 0 } });
		SparseMatrix matrix5 = new SparseMatrix(new int[][] { { 0, 2 },
				{ 2, 0 } });

		System.out.println("After Addition:");

		int addition[][] = matrix3.add(matrix4);
		for (int i = 0; i < addition.length; i++) {
			for (int j = 0; j < addition[0].length; j++) {
				System.out.print(addition[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("After Multiplication:");

		int multiplication[][] = matrix1.multiply(matrix2);
		for (int i = 0; i < multiplication.length; i++) {
			for (int j = 0; j < multiplication[0].length; j++) {
				System.out.print(multiplication[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("After Transpose:");

		int transpose[][] = matrix2.transpose();
		for (int i = 0; i < transpose.length; i++) {
			for (int j = 0; j < transpose[0].length; j++) {
				System.out.print(transpose[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println(matrix5.checkSymmetrical());

	}
}
