package PriorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPriorityQueue {

	/**
	 * Helper function to check whether the element exist in the queue which is
	 * entered or not
	 * 
	 * @param element
	 * @return true or false
	 */
	boolean checkElementinQueue(int element, QueueItem queue[]) {

		for (int i = 0; i < queue.length; i++) {
			if (element == queue[i].getItem()) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void testForAddElement() {

		QueueItem queueArray[] = new QueueItem[6];
		Queue queue = new PriorityQueue(queueArray);
		boolean result = queue.addElement(4, 10);

		assertEquals(true, result);
	}

	@Test
	public void testgetHighestPriorityElement() {

		QueueItem queueArray[] = new QueueItem[6];
		Queue queue = new PriorityQueue(queueArray);

		queue.addElement(4, 10);
		queue.addElement(5, 10);
		queue.addElement(5, 9);
		queue.addElement(6, 8);
		queue.addElement(7, 7);

		assertEquals(4, queue.getHighestPriorityElement());
	}

	@Test
	public void testRemovetHighestPriorityElement() {

		QueueItem queueArray[] = new QueueItem[6];
		Queue queue = new PriorityQueue(queueArray);

		queue.addElement(4, 10);
		queue.addElement(5, 9);
		queue.addElement(6, 8);
		queue.addElement(7, 7);

		assertEquals(true, queue.deleteHighestPriorityElement());
	}

	@Test
	public void testisFull() {

		QueueItem queueArray[] = new QueueItem[4];
		Queue queue = new PriorityQueue(queueArray);

		queue.addElement(4, 10);
		queue.addElement(5, 9);
		queue.addElement(6, 8);
		queue.addElement(7, 7);

		assertEquals(true, queue.isFull());
	}

	@Test
	public void testisEmpty() {

		QueueItem queueArray[] = new QueueItem[4];
		Queue queue = new PriorityQueue(queueArray);
		queue.addElement(4, 10);
		assertEquals(false, queue.isEmpty());
	}

}
