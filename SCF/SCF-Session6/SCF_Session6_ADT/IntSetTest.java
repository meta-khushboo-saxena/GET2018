package SCF_Session6_ADT;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {
	IntSet set1 = new IntSet(new int[] { 3, 4, 5, 1, 2 });

	@Test
	public void testSize() {
		int result = set1.size();
		assertEquals(5, result);
	}

	@Test
	public void testIsMember() {
		boolean result = set1.isMember(5);
		assertEquals(true, result);
	}

	@Test
	public void testIsSubset() {
		IntSet set2 = new IntSet(new int[] { 1, 2 });
		boolean result = set1.isSubSet(set2);
		assertEquals(true, result);
	}

	@Test
	public void testGetComplement() {
		IntSet set3 = new IntSet(new int[] { 1, 2 });
		int result[] = set3.getComplement();
		int expected[] = { 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(expected, result);
	}

	@Test
	public void testUnion() {
		IntSet set = new IntSet();
		IntSet set4 = new IntSet(new int[] { 4, 2, 9, 8, 5, 6 });
		IntSet set5 = new IntSet(new int[] { 4, 2, 1 });
		int result[] = set.union(set4, set5);
		int expected[] = { 1, 2, 4, 5, 6, 8, 9 };
		assertArrayEquals(expected, result);
	}

}
