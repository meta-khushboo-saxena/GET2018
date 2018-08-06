package CircularQueue;

import Queue.Queue;

/**
 * Class to implement circular queue
 */
public class CircularQueue implements Queue<Integer> {

	public int queue[];
	public int frontPointer = -1;
	public int rearPointer = -1;

	/**
	 * Constructor to initialize the size of queue
	 * 
	 * @param size
	 */
	public CircularQueue(int size) {
		queue = new int[size];
	}

	/**
	 * Function to check if the queue is full
	 * 
	 * @return true if queue is full
	 */
	public boolean isFull() {
		boolean flag = false;
		if ((frontPointer == rearPointer + 1) || (frontPointer == 0 && rearPointer == queue.length - 1)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to check if the queue is empty
	 * 
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		boolean flag = false;
		if (frontPointer == -1 && rearPointer == -1) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to push an elements in the queue
	 */
	public void push(Integer element) {

		if (isEmpty()) {
			frontPointer = 0;
			rearPointer = 0;
			queue[rearPointer] = element;

		} else {
			if (isFull()) {
				System.out.println("!!Stack Overflow!!");
			}
			if (rearPointer == queue.length - 1) {
				rearPointer = 0;
			} else {
				rearPointer = rearPointer + 1;
			}
			queue[rearPointer] = element;
		}
	}

	/**
	 * Function to delete an element from queue
	 */
	public Integer pop() {

		if (isEmpty()) {
			System.out.println("!!Stack Underflow!!");
			return -1;
		}

		int result = queue[frontPointer];

		if (frontPointer == rearPointer) {
			frontPointer = rearPointer = -1;

		} else {
			if (frontPointer == queue.length - 1) {
				frontPointer = 0;

			} else {

				frontPointer++;
			}
		}
		return result;
	}

	/**
	 * Function to display elements of queue and return count
	 */
	public int show() {
		int count = 0, i;
		if (isEmpty()) {
			
			System.out.println(" \n Empty Queue\n");
			
		} else {
			
			System.out.println("\nElements in queue are:");
			for (i = frontPointer; i != rearPointer; i = (i + 1) % queue.length) {
				System.out.println(queue[i]);
				count++;
				
			}
			System.out.println(queue[i]);
			count++;
		}
		return count;
	}

}
