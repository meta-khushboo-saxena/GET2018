package Stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {
	StackUsingArray stackUsingArray = new StackUsingArray(4);
	StackUsingLinkList stackUsingLinklist = new StackUsingLinkList();

	@Test
	public void testisEmpty1() {
		boolean result = stackUsingArray.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testisEmpty2() {
		stackUsingArray.push(34);
		boolean result = stackUsingArray.isEmpty();
		assertEquals(false, result);
	}
	
	@Test
	public void testisEmpty3() {
		stackUsingArray.push(34);
		stackUsingArray.pop();
		boolean result = stackUsingArray.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testisFull1() {
		boolean result = stackUsingArray.isFull();
		assertEquals(false, result);
	}

	@Test
	public void testisFull2() {
		stackUsingArray.push(10);
		stackUsingArray.push(34);
		stackUsingArray.push(12);
		stackUsingArray.push(88);
		stackUsingArray.show();
		boolean result = stackUsingArray.isFull();
		assertEquals(true, result);
	}

	@Test
	public void testPush() {
		stackUsingArray.push(10);
		stackUsingArray.push(34);
		int result = stackUsingArray.show();
		assertEquals(2, result);
	}
	
	@Test
	public void testPop() {
		stackUsingArray.push(10);
		stackUsingArray.push(34);
		stackUsingArray.pop();
		int result = stackUsingArray.show();
		assertEquals(1, result);
	}
	
	@Test
	public void testisEmptyUsingList1() {
		boolean result = stackUsingLinklist.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testisEmptyUsingList2() {
		stackUsingLinklist.push(88);
		boolean result = stackUsingLinklist.isEmpty();
		assertEquals(false, result);
	}
	
	@Test
	public void testisEmptyUsingList3() {
		stackUsingLinklist.push(88);
		stackUsingLinklist.pop();
		boolean result = stackUsingLinklist.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testPushUsingList() {
		stackUsingLinklist.push(78);
		stackUsingLinklist.push(75);
		int result = stackUsingLinklist.show();
		assertEquals(2, result);
	}
	
	@Test
	public void testPopUsingList() {
		stackUsingLinklist.push(112);
		stackUsingLinklist.push(145);
		stackUsingLinklist.push(80);
		stackUsingLinklist.pop();
		int result = stackUsingLinklist.show();
		assertEquals(2, result);
	}

}
