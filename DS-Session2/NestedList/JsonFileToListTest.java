package NestedList;

import static org.junit.Assert.*;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class JsonFileToListTest {
	JSONReadFile integersList;
	List<Object> nestedList;
	public final String FILEINTEGER = "C:\\Users\\user38\\Downloads\\jsonfiles\\Integers1.json";
	public final String JSONFILE = "C:\\Users\\user38\\Downloads\\jsonfiles\\Integers2.json";
	public final String FILE = "C:\\Users\\user38\\Downloads\\jsonfiles\\Integers3.json";
	public final String FILETEST = "C:\\Users\\user38\\Downloads\\jsonfiles\\Integers4.json";

	@Before
	public void init() throws FileNotFoundException {
		nestedList = new LinkedList<Object>();
		integersList = new JSONReadFile();
		integersList.addList(FILEINTEGER);
		integersList.addList(JSONFILE);
		integersList.addList(FILE);
		nestedList = integersList.addList(FILETEST);
	}

	@Test
	public void addAllIntegersTest() {
		assertEquals(384, integersList.getSum(nestedList));
	}

	@Test
	public void largestIntegerTest() {
		assertEquals(576, integersList.getLargest(nestedList));
	}

	@Test
	public void searchElementTest() {
		assertTrue(integersList.search(-12, nestedList));
	}

	@Test
	public void addListWithNull() throws FileNotFoundException {
		try {
			integersList.addList(null);
		} catch (NullPointerException ex) {
			assertEquals("FileName Can't be Empty", ex.getMessage());
		}
	}

	@Test
	public void addListFileNotFound() {
		try {
			integersList.addList("AddInteger.json");
		} catch (FileNotFoundException ex) {
			assertEquals("File not Found in addList", ex.getMessage());
		}
	}

	@Test
	public void testGetValueHead1() {
		int result = (Integer) integersList.getValue("HH", nestedList);
		assertEquals(result, 2);
	}

	@Test
	public void testGetValueHead2() {
		int result = (Integer) integersList.getValue("THH", nestedList);
		assertEquals(result, 12);
	}

	@Test(expected = AssertionError.class)
	public void testGetValueHead3() {
		integersList.getValue("TH", nestedList);
	}

	@Test(expected = AssertionError.class)
	public void testGetValueHead4() {
		integersList.getValue("HT", nestedList);
	}

}
