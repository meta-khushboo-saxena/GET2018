package UniqueCharacter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class to count the unique characters in the string
 */
class StringCharacterCount {
	public Map<String, Integer> stringMap = new HashMap<String, Integer>();

	/**
	 * Function to get the count of unique characters
	 * 
	 * @param data
	 * @return
	 */
	public int getCharacterCount(String data) {

		// if the previously string is encountered then returned the stored result
		if (stringMap.containsKey(data)) {
			return stringMap.get(data);
		}
		char[] characterArray = data.trim().toCharArray();

		// storing the characters in the set
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < characterArray.length; i++) {
			if (characterArray[i] != ' ') {
				set.add(characterArray[i]);
			}
		}
		stringMap.put(data, set.size());
		return set.size();
	}
}
