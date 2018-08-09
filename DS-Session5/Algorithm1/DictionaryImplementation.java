package Algorithm1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * 
 * Class for Implementing the dictionary
 *
 */
public class DictionaryImplementation implements Dictionary {

	private BinarySearchTree binary = new BinarySearchTree();
	private List<KeyValuePair> listsorted;

	/**
	 * Constructor for reading word from json and storing it in dictionary
	 * 
	 * @throws FileNotFoundException
	 */
	public DictionaryImplementation(String fileName) throws FileNotFoundException {
		if (fileName == null) {
			throw new NullPointerException("fileName can't be Null");
		}
		try {
			File jsonInputFile = new File(fileName);
			InputStream input = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(input);
			JsonObject jsonObj = reader.readObject();
			reader.close();

			// storing the key in the set
			Set<String> keys = jsonObj.keySet();

			// getting the value of all the keys and putting in dictionary
			Iterator<String> iterator = keys.iterator();

			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				KeyValuePair pair = new KeyValuePair(key, jsonObj.get(key).toString());

				// Adding key value pairs in BST
				binary.insert(pair);

			}
		} catch (FileNotFoundException ex) {
			throw new FileNotFoundException("fileName not Found");
		}
	}

	/**
	 * Function to manually add words or anthing in the dictionary
	 * 
	 * @param key : storing word or data values
	 * @param value : storing meaning for key values
	 * @return true or false
	 */
	@Override
	public boolean addWord(String key, String value) {
		if (key == null || value == null) {
			throw new NullPointerException("Key or Value to be Added can't be Null");
		}
		KeyValuePair pair = new KeyValuePair(key, value);
		binary.insert(pair);
		return true;
	}

	/**
	 * Function to delete a particular entry from dictionary
	 * 
	 * @param key which is the data for deletion from dictionary along with its
	 * meaning
	 */
	@Override
	public boolean deleteWord(String key) {
		if (key == null) {
			System.out.println("Key to be Deleted can't be Null");
		}
		binary.deleteKey(key);
		return true;
	}

	/**
	 * Function to get the specified value meaning from the dictionary
	 * 
	 * @param key to search and get the meaning for the particular entry
	 * 
	 * @return the meaning of the entry specified
	 */
	@Override
	public String getValue(String key) {
		if (key == null) {
			throw new NullPointerException("Please enter some input");
		}
		return binary.search(key);
	}

	/**
	 * Function to get the sorted list of the entries in the dictionary
	 * 
	 * @return sorted list of entries
	 */
	@Override
	public List<KeyValuePair> sortInorder() {
		listsorted = binary.sortInorder();
		return listsorted;
	}

	/**
	 * Function to sort the dictionary between two entries given by user
	 * 
	 * @param key1
	 * @param key2
	 * @return list of entries in between the given range
	 */
	@Override
	public List<KeyValuePair> sortDictionaryInRange(String key1, String key2) {

		List<KeyValuePair> sortedInRange = new ArrayList<>();

		Iterator<KeyValuePair> listInRange = listsorted.iterator();

		while (listInRange.hasNext()) {
			KeyValuePair pair = listInRange.next();

			if (key1.compareTo(pair.getkey()) <= 0 && key2.compareTo(pair.getkey()) >= 0) {

				sortedInRange.add(pair);
			}
		}
		if (sortedInRange.size() == 0) {
			System.out.println("!! Nothing therein between Range or input is Incorrect !!");
		}
		return sortedInRange;
	}

}
