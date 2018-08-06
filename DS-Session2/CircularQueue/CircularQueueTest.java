package CircularQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

	CircularQueue circleQueue = new CircularQueue(4);

	@Test
	public void testisEmpty1() {
		boolean result = circleQueue.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testisEmpty2() {
		circleQueue.push(99);
		boolean result = circleQueue.isEmpty();
		assertEquals(false, result);
	}

	@Test
	public void testisEmpty3() {
		circleQueue.push(12);
		circleQueue.pop();
		boolean result = circleQueue.isEmpty();
		assertEquals(true, result);
	}

	@Test
	public void testisFull1() {
		boolean result = circleQueue.isFull();
		assertEquals(false, result);
	}

	@Test
	public void testisFull2() {
		circleQueue.push(98);
		circleQueue.push(5);
		circleQueue.push(6);
		circleQueue.push(3);
		circleQueue.show();
		boolean result = circleQueue.isFull();
		assertEquals(true, result);
	}

	@Test
	public void testPush() {
		circleQueue.push(112);
		circleQueue.push(145);
		circleQueue.pop();
		circleQueue.pop();
		circleQueue.push(80);
		circleQueue.push(88);
		circleQueue.push(34);
		circleQueue.push(34);
		int result = circleQueue.show();
		assertEquals(4, result);
	}

	@Test
	public void testPop() {
		circleQueue.push(112);
		circleQueue.push(145);
		circleQueue.push(80);
		circleQueue.push(88);
		circleQueue.pop();
		circleQueue.pop();
		circleQueue.pop();
		circleQueue.pop();
		int result = circleQueue.show();
		assertEquals(0, result);
	}

	@Test
	public void testPop1() {
		circleQueue.push(112);
		circleQueue.push(145);
		circleQueue.pop();
		circleQueue.pop();
		circleQueue.push(80);
		circleQueue.push(88);
		int result = circleQueue.pop();
		circleQueue.show();
		assertEquals(80, result);
	}
}
