package SCF_Session6_ADT;

/**
 *Immutable class for performing various operations on set
 */
final class IntSet {

	int UniversalSet[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private int setArray[];

	public void sort(int array[], int n) {
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public IntSet() {

	}

	/**
	 * function to set the value of set array
	 * @param setArray
	 */
	public IntSet(int setArray[]) {
		this.setArray = setArray;
	}

	/**
	 * function to calculate the size of array
	 */
	public int size() {
		return setArray.length;
	}

	/**
	 * function to check if the number entered is member of set
	 * @param x
	 */
	public boolean isMember(int x) {
		for (int i = 0; i < size(); i++) {
			if (setArray[i] == x) {
				return true;
			}
		}
		return false;
	}

	/**
	 * function to check if the set entered is subset of the given set
	 * @param s:object containing the set
	 */
	public boolean isSubSet(IntSet s) {
		int array[] = s.setArray;
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < size(); j++) {
				if (array[i] == setArray[j]) {
					count++;
				}
			}
		}
		if (count == s.size()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * function to get the complement of the given set
	 */
	public int[] getComplement() {
		int count;
		int k = 0;
		int ComplementArray[] = new int[UniversalSet.length - size()];
		for (int i = 0; i < UniversalSet.length; i++) {
			count = 0;
			for (int j = 0; j < size(); j++) {
				if (setArray[j] != UniversalSet[i]) {
					count++;
				}
			}
			if (count == size()) {
				ComplementArray[k] = UniversalSet[i];

				k++;
			}
		}
		return ComplementArray;
	}

	/**
	 * function to find the union of two sets
	 * @param s1
	 * @param s2
	 */
	public int[] union(IntSet s1, IntSet s2) {

		int i, k, count = 0;
		int j = 0;

		for (i = 0; i < s1.size(); i++) {

			for (k = 0; k < s2.size(); k++) {
				if (s1.setArray[i] == s2.setArray[k]) {
					count++;
					break;
				}
			}
		}
		int UnionSet[] = new int[s1.size() + s2.size() - count];

		for (i = 0; i < s1.size(); i++) {
			count = 0;
			for (k = 0; k < s2.size(); k++) {
				if (s1.setArray[i] == s2.setArray[k]) {
					count++;
				}
			}
			if (count == 0) {
				UnionSet[j] = s1.setArray[i];
				j++;
			}
		}
		for (i = j, k = 0; i < j + s2.size(); i++) {
			UnionSet[i] = s2.setArray[k];
			k++;
		}
		sort(UnionSet, j + s2.size());

		return UnionSet;

	}

}
