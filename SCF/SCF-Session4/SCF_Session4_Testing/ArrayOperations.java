package SCF_Session4_Testing;

public class ArrayOperations {
	private int indexArrayX[] = {};
	private int indexArrayY[] = {};
	private int countx = 0;
	private int county = 0;

	/**
	 * Function to check array is empty or not
	 * 
	 * @param array
	 *            throws assertionError if array is empty
	 */
	void checkEmpty(int array[]) {
		if (array.length <= 0) {
			throw new AssertionError("!! Empty Array !!");
		}
	}

	/**
	 * Function to check count of X and Y in fix
	 * 
	 * @param array
	 * @param x
	 * @param y
	 */
	void countXY(int array[], int X, int Y) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == X) {
				countx++;
			}
			if (array[i] == Y) {
				county++;
			}
		}
	}

	/**
	 * Function to check two adjacent X
	 * 
	 * @param array
	 * @param x
	 *            throws assertionError if there are two adjacent x values
	 */
	void checkAdjacentValue(int array[], int x) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == x && array[i + 1] == x) {
				throw new AssertionError("There are two adjacent value of x");
			}
		}
	}

	/**
	 * Calculates Max mirror length in array
	 * 
	 * @param array
	 * @return max: length of mirror found
	 */
	public int maxMirror(int[] array) {
		checkEmpty(array);
		int count = 0, max = 0;
		int i, j, k = 0;
		for (i = 0; i < array.length; i++) {

			for (k = i, j = array.length - 1; k < array.length && j >= 0; j--) {
				if (array[k] == array[j]) {
					count++;
					k++;
					if (count > array.length) {
						break;
					}
					if (max < count) {
						max = count;
					}
				} else {

					count = 0;
				}
			}
		}
		return max;
	}

	/**
	 * Calculates max numbers of Adjacent elements in array
	 * 
	 * @param array
	 * @return count: adjacent elements
	 */

	public int clumps(int[] array) {
	checkEmpty(array);
	int count = 0, index=0;
	for (int i = 0; i < array.length - 1; i++) {
		if (array[i] == array[i + 1]) {
			if(index==i){
				count++;
			}
		}else{
			index=i+1;
		}
	}
	return count;
}

	/**
	 * function for rearranging the array such that every x is immediately
	 * followed by y and x cannot be moved
	 * 
	 * @param array
	 * @param x
	 * @param y
	 * @return array with correct positioning elements
	 */
	public int[] fixXY(int array[], int x, int y) {
		int i;
		checkEmpty(array);
		countXY(array, x, y);
		checkAdjacentValue(array, x);

		if (countx != county) {
			throw new AssertionError("Unequal number of X and Y");
		} else if (array[array.length - 1] == x) {
			throw new AssertionError("X cannot be at last position");
		} else {
			indexArrayX = new int[countx];
			indexArrayY = new int[county];
			int j = 0, k = 0;
			for (i = 0; i < array.length; i++) {
				if (array[i] == x) {
					indexArrayX[j] = i;
					j++;
				}
				if (array[i] == y) {
					indexArrayY[k] = i;
					k++;
				}
			}

			for (i = 0; i < countx; i++) {
				int temp;
				temp = array[indexArrayX[i] + 1];
				array[indexArrayX[i] + 1] = array[indexArrayY[i]];
				array[indexArrayY[i]] = temp;
			}
			return array;
		}

	}

	/**
	 * function for splitting the array
	 * 
	 * @param array
	 * @return i:index if splitting is possible else return 1
	 */
	public int splitArray(int array[]) {
		checkEmpty(array);
		int leftsum, rightsum, j, i;
		int length = array.length;

		for (i = 0; i < length; i++) {
			leftsum = 0;
			for (j = 0; j < i; j++) {
				leftsum += array[j];
			}
			rightsum = 0;
			for (j = i; j < length; j++) {
				rightsum += array[j];
			}
			if (leftsum == rightsum) {

				return i;
			}
		}

		return -1;
	}

}
