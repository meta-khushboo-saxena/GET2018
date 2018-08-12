package NestedList;

import static org.junit.Assert.*;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class NestedListUsingJsonTest {
	NestedListUsingJson integersList;
	List<Object> nestedList = new LinkedList<Object>();
	public final String FILEINTEGER = "src\\Integers1.json";

	@Before
	public void init() throws FileNotFoundException {
		integersList = new NestedListUsingJson(FILEINTEGER);
		nestedList = integersList.getNestedList();
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
	public void searchElementTest1() {
		assertTrue(integersList.search(124, nestedList));
	}

	@Test
	public void searchElementTest2() {
		assertFalse(integersList.search(-1222, nestedList));
	}

	@Test
	public void addListWithNull() throws FileNotFoundException {
		try {
			integersList = new NestedListUsingJson(null);
		} catch (NullPointerException ex) {
			assertEquals("FileName Can't be Empty", ex.getMessage());
		}
	}

	@Test
	public void addListFileNotFound() {
		try {
			integersList = new NestedListUsingJson("AddInteger.json");
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

	@Test
	public void testGetValueHead5() {
		int result = (Integer) integersList.getValue("TTHH", nestedList);
		assertEquals(result, 123);
	}
}
