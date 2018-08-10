package Algorithm1;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

//Test class for testing Dictionary
public class TestDictionary {
	Dictionary dict;

	@Before
	public void initialize() throws FileNotFoundException {
		dict = new DictionaryImplementation("src\\dictionary.json");
	}

	@Test
	public void testForAddWord1() {
		assertEquals(true, dict.addWord("Nik", "aaaaa"));
		assertEquals(true, dict.addWord("A", "AAAAaaaaa"));
		assertEquals(true, dict.addWord("Nikkkk", "aaaaa"));
		assertEquals(true, dict.addWord("2", "Two"));
		assertEquals(true, dict.addWord("3", "Three"));
	}

	@Test
	public void testForAddWord2() {
		assertEquals(false, dict.addWord("", ""));
	}

	@Test
	public void testForDeleteWord1() {
		assertEquals(true, dict.deleteWord("Attitude"));
		assertEquals(true, dict.deleteWord("A"));
	}

	@Test
	public void testForDeleteWord2() {
		assertEquals(false, dict.deleteWord(""));
	}

	@Test
	public void testForGetValue1() {
		String value = dict.getValue("Attribute");
		assertEquals("a quality or characteristic that someone or something has", value);
	}

	@Test
	public void testForGetValue2() {
		String value = dict.getValue("");
		assertEquals(null, value);
	}

	@Test
	public void testForSortingOfDictionary() {
		List<KeyValuePair> list = dict.sortDictionary();
		assertEquals("1", list.get(0).getkey());
		assertEquals("Anticipate", list.get(1).getkey());
		assertEquals("Attitude", list.get(2).getkey());
		assertEquals("Attribute", list.get(3).getkey());
		assertEquals("Content", list.get(4).getkey());
	}

	@Test
	public void testForSortDictionaryInRange() {

		List<KeyValuePair> list = dict.sortDictionaryInRange("Attitude", "Sophisticated");
		assertEquals("Attitude", list.get(0).getkey());
		assertEquals("Attribute", list.get(1).getkey());
		assertEquals("Content", list.get(2).getkey());
		assertEquals("Culture", list.get(3).getkey());
		assertEquals("Sophisticated", list.get(4).getkey());
	}
}
