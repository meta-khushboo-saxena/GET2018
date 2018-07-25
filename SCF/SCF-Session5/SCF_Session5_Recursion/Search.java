package SCF_Session5_Recursion;

public class Search {

	/**
	 * function to find the value in the array by Binary Search
	 * 
	 * @param a : array
	 * @param lowIndex
	 * @param highIndex
	 * @param value
	 * @return index if the element is found else return -1
	 */
	int binarySearch(int a[], int lowIndex, int highIndex, int value) {
		if (highIndex >= lowIndex) {
			int midIndex = (lowIndex + highIndex) / 2;
			if (a[midIndex] == value) {
				return midIndex;
			}
			if (a[midIndex] > value) {
				return binarySearch(a, lowIndex, midIndex - 1, value);
			}
			return binarySearch(a, (midIndex + 1), highIndex, value);
		}
		return -1;
	}

	/**
	 * function to initialise lower index and highindex
	 * 
	 * @param a :array
	 * @param value
	 * @return
	 */
	public int binary(int a[], int value) {
		int lowIndex = 0;
		int highIndex = a.length - 1;
		return binarySearch(a, lowIndex, highIndex, value);

	}

	/**
	 * function to find the value in the array by Linear Search
	 * 
	 * @param a : array
	 * @param index
	 * @param lastIndex
	 * @param value
	 * @return index if the element is found else return -1
	 */
	public int linearSearch(int array[], int index, int lastIndex, int value) {
		if (index <= lastIndex) {
			if (array[index] == value) {
				return index;
			} else {
				return linearSearch(array, index + 1, lastIndex, value);
			}
		}
		return -1;
	}

	/**
	 * function to initialise lower index and highindex
	 * 
	 * @param a :array
	 * @param value
	 * @return
	 */
	public int linear(int a[], int value) {
		int lowIndex = 0;
		int highIndex = a.length - 1;
		return linearSearch(a, lowIndex, highIndex, value);

	}

}
