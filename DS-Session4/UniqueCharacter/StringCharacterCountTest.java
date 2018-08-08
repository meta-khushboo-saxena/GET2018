package UniqueCharacter;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCharacterCountTest {

	@Test
	public void testWithCount10() {
		StringCharacterCount count = new StringCharacterCount();
		assertEquals(8, count.getCharacterCount("This is a dog"));
	}

	@Test
	public void testWithCount() {
		StringCharacterCount count = new StringCharacterCount();
		assertEquals(8, count.getCharacterCount("This is a dog"));
		assertEquals(13, count.getCharacterCount("We went Delhi by bus"));
		assertEquals(8, count.getCharacterCount("This is a dog"));
	}

	@Test
	public void testWithCount2() {
		StringCharacterCount count = new StringCharacterCount();
		assertEquals(9, count.getCharacterCount("Where is Radha"));
		assertEquals(14, count.getCharacterCount("Can we Go! Who is there"));
	}

	@Test
	public void testWithCount3() {
		StringCharacterCount count = new StringCharacterCount();
		assertEquals(9, count.getCharacterCount("@  this man ##"));
	}

}