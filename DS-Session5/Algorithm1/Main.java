package Algorithm1;

import java.util.Iterator;
import java.util.List;

/**
 * Temporary main class for testing in console
 */

public class Main {
	public static void main(String args[]) throws Exception {

		Dictionary dict = new DictionaryImplementation("src\\dictionary.json");
		dict.addWord("Nik", "aaaaa");
		dict.addWord("A", "AAAAaaaaa");
		dict.addWord("Nikkkk", "aaaaa");
		dict.addWord("Aqiii", "AAAAaaaaa");

		System.out.println(dict.deleteWord("njngjnsfgi"));

		List<KeyValuePair> sortedList = dict.sortInorder();

		Iterator<KeyValuePair> itr = sortedList.iterator();

		while (itr.hasNext()) {
			KeyValuePair pair = itr.next();
			System.out.println("word : " + pair.getkey() + "---->Meaning : " + pair.getValue());
		}

		System.out.println("-----------------------Range---------------------------------");

		List<KeyValuePair> sortedRange = dict.sortDictionaryInRange("Attitude", "Nik");

		Iterator<KeyValuePair> itr1 = sortedRange.iterator();

		while (itr1.hasNext()) {
			KeyValuePair pair = itr1.next();
			System.out.println("word : " + pair.getkey() + "---->Meaning : " + pair.getValue());
		}
	}
}
