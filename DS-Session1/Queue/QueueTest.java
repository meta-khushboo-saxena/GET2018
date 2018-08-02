package Queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	QueueUsingArray queueUsingArray = new QueueUsingArray(4);
	QueueUsingList queueUsingList = new QueueUsingList();

	@Test
	public void testisEmpty1() {
		boolean result = queueUsingArray.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testisEmpty2() {
		queueUsingArray.push(99);
		boolean result = queueUsingArray.isEmpty();
		assertEquals(false, result);
	}
	
	@Test
	public void testisEmpty3() {
		queueUsingArray.push(12);
		queueUsingArray.pop();
		boolean result = queueUsingArray.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testisFull1() {
		boolean result = queueUsingArray.isFull();
		assertEquals(false, result);
	}

	@Test
	public void testisFull2() {
		queueUsingArray.push(98);
		queueUsingArray.push(5);
		queueUsingArray.push(6);
		queueUsingArray.push(3);
		queueUsingArray.show();
		boolean result = queueUsingArray.isFull();
		assertEquals(true, result);
	}

	@Test
	public void testPush() {
		queueUsingArray.push(66);
		queueUsingArray.push(1);
		int result = queueUsingArray.show();
		assertEquals(2, result);
	}
	
	@Test
	public void testPop() {
		queueUsingArray.push(7);
		queueUsingArray.push(5);
		queueUsingArray.pop();
		int result = queueUsingArray.show();
		assertEquals(1, result);
	}
	
	@Test
	public void testisEmptyUsingList1() {
		boolean result = queueUsingList.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testisEmptyUsingList2() {
		queueUsingList.push(3);
		boolean result = queueUsingList.isEmpty();
		assertEquals(false, result);
	}
	
	@Test
	public void testisEmptyUsingList3() {
		queueUsingList.push(4);
		queueUsingList.pop();
		boolean result = queueUsingList.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testPushUsingList() {
		queueUsingList.push(78);
		queueUsingList.push(75);
		int result = queueUsingList.show();
		assertEquals(2, result);
	}
	
	@Test
	public void testPopUsingList() {
		queueUsingList.push(112);
		queueUsingList.push(145);
		queueUsingList.push(80);
		queueUsingList.pop();
		int result = queueUsingList.show();
		assertEquals(2, result);
	}
}
