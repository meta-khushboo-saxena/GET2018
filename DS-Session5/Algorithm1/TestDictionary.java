package Algorithm1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class TestDictionary {
	Dictionary dict;

	@Before
	public void initialize() throws FileNotFoundException {
		dict = new DictionaryImplementation("src\\dictionary.json");
	}

	@Test
	public void testForaddWord() {
		assertEquals(true, dict.addWord("Nik", "aaaaa"));
		assertEquals(true, dict.addWord("A", "AAAAaaaaa"));
		assertEquals(true, dict.addWord("Nikkkk", "aaaaa"));
		assertEquals(true, dict.addWord("1", "One"));
		assertEquals(true, dict.addWord("2", "Two"));
		assertEquals(true, dict.addWord("3", "Three"));
	}
}
