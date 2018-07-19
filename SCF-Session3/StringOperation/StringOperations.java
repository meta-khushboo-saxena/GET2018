package StringOperation;

/*
 * contain function to perform various operations on string
 */
public class StringOperations {

	/**
	 * compare two strings
	 * 
	 * @param string1
	 *            ,string2
	 * @return 1 if same else 0
	 */
	int compareStrings(String string1, String string2) {
		if (string1.length() == string2.length()) {
			for (int i = 0; i < string1.length(); i++) {
				if (string1.charAt(i) == string2.charAt(i)) {
					continue;
				} else {
					return 0;
				}
			}
			return 1;
		}
		return 0;
	}

	/**
	 * Reverse a String
	 * 
	 * @param string
	 * @return reversestring
	 */
	String stringReverse(String string) {
		String reversestring = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			reversestring += string.charAt(i);
		}
		return reversestring;
	}

	/**
	 * Change case of the string
	 * 
	 * @param string
	 * @return newString
	 */
	String CaseChange(String string) {

		String newString = "";

		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) >= 65 && string.charAt(i) <= 90) {
				newString += (char) (string.charAt(i) + 32);

			} else if (string.charAt(i) >= 97 && string.charAt(i) <= 122) {
				newString += (char) (string.charAt(i) - 32);

			} else {
				newString += string.charAt(i);

			}
		}

		return newString;
	}

	/**
	 * Find longest word in a String
	 * 
	 * @param string
	 * @return longestString
	 */
	String LongestWordFromString(String string) {
		String longestString = "";
		int i = 0, length = 0, max = 0, startindex = 0, endindex = 0;
		while (i < string.length()) {
			length++;
			if (string.charAt(i) == ' ') {
				if (max < length) {
					max = length - 1;
					startindex = i - max;
				}
				length = 0;
			}
			i++;
		}
		endindex = startindex + max;

		for (i = startindex; i < endindex; i++) {
			longestString += string.charAt(i);
		}
		return longestString;
	}
}
