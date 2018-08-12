package NestedList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 * Class to read json file and insert data in the list
 */
class NestedListUsingJson implements NestedList {
	private boolean searchData = false;
	private int result;
	private List<Object> nestedList = new LinkedList<Object>();

	/**
	 * Constructor to initialiZe the nested list
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public NestedListUsingJson(String fileName) throws FileNotFoundException {
		if (fileName == null) {
			throw new NullPointerException("FileName Can't be Empty");
		}
		try {

			File jsonInputFile = new File(fileName);
			InputStream input = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(input);
			JsonObject jsonObj = reader.readObject();
			reader.close();

			JsonArray jsonArray = jsonObj.getJsonArray("nestedList");
			for (JsonValue value : jsonArray) {
				JsonObject jsonObjList1 = (JsonObject) value;
				JsonArray list1 = jsonObjList1.getJsonArray("Integers");

				LinkedList<Integer> integerList = new LinkedList<>();
				for (JsonValue value1 : list1) {
					integerList.add(Integer.parseInt(value1.toString()));
				}
				nestedList.add(integerList);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not Found in addList");
		}
	}

	public List<Object> getNestedList() {
		return this.nestedList;
	}

	/**
	 * Function to get the sum of all the elements in the list
	 */
	@SuppressWarnings("unchecked")
	public int getSum(List<Object> list) {
		int getSumOfList = 0;
		Iterator<Object> outter = list.iterator();
		while (outter.hasNext()) {
			Object outObject = outter.next();
			if (outObject instanceof List) {
				getSumOfList += getSum((List<Object>) outObject);
			} else {
				int outValue = (Integer) outObject;
				getSumOfList += outValue;
			}
		}
		return getSumOfList;
	}

	/**
	 * Function to get the largest element in the nested list
	 */
	@SuppressWarnings("unchecked")
	public int getLargest(List<Object> list) {
		int largest = 0;
		Iterator<Object> outter = list.iterator();
		while (outter.hasNext()) {
			Object outObject = outter.next();
			if (outObject instanceof List) {
				if (getLargest((List<Object>) outObject) > largest) {
					largest = getLargest((List<Object>) outObject);
				}
			} else {
				int outValue = (Integer) outObject;
				if (outValue > largest) {
					largest = outValue;
				}
			}
		}
		return largest;
	}

	/**
	 * Function to search a value in the nested list
	 */
	@SuppressWarnings("unchecked")
	public boolean search(int value, List<Object> list) {

		Iterator<Object> outter = list.iterator();
		while (outter.hasNext()) {
			Object outObject = outter.next();
			if (outObject instanceof List) {
				searchData = search(value, (List<Object>) outObject);
			} else {
				int outValue = (Integer) outObject;
				if (outValue == value) {
					return true;
				}
			}
		}
		return searchData;
	}

	/**
	 * Function to get the integer according to the given pattern
	 */
	@SuppressWarnings("unchecked")
	public int getValue(String positionString, List<Object> list) {
		System.out.println(list);

		if (positionString.charAt(positionString.length() - 1) == 'T'
				|| list.size() < positionString.length()) {
			throw new AssertionError("Invalid List");
		} else {
			if (positionString.charAt(0) == 'H' && positionString.length() == 1) {
				if (list.get(0) instanceof List) {
					throw new AssertionError("Integer instance found at head");

				} else {
					result = (Integer) list.get(0);
				}
			} else if (positionString.charAt(0) == 'T') {
				if (list.size() == 1) {
					throw new AssertionError("List is empty");
				}
				list.remove(0);
				getValue(positionString.substring(1, positionString.length()),
						(List<Object>) list);
			} else if (positionString.charAt(0) == 'H' && list.size() != 1) {
				getValue(positionString.substring(1, positionString.length()),
						(List<Object>) list.get(0));
			} else {
				System.out.println("!!Invalid pattern!!");
				return 0;
			}
		}
		return result;
	}
}
