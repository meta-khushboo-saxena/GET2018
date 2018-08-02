package Queue;

import Node.Node;

public class QueueUsingList implements Queue {
	Node frontNode = null;
	Node rearNode = null;

	/**
	 * Function to check if the queue is empty
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		boolean flag = false;
		if (frontNode == null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to push an elements in the queue
	 */
	public void push(int element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = null;
		if (frontNode == null) {
			frontNode = rearNode = newNode;
		}
		rearNode.next = newNode;
		rearNode = rearNode.next;
	}

	/**
	 * Function to delete an element from queue
	 */
	public void pop() {

		if (isEmpty()) {
			System.out.println("!!Stack is Empty!!");
		} else if (frontNode == rearNode) {
			frontNode = rearNode = null;

		} else {
			Node newNode = new Node();
			newNode = frontNode;
			newNode.data = frontNode.data;
			frontNode = frontNode.next;
			newNode = null;
		}
	}

	/**
	 * Function to display elements of queue and return count
	 */
	public int show() {
		int count = 0;
		Node traverse = new Node();
		traverse = frontNode;
		System.out.println("Queue Element using LinkList ");
		while (traverse != rearNode.next) {
			System.out.println(traverse.data);
			traverse = traverse.next;
			count++;
		}
		return count;
	}
}
