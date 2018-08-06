package Queue;

public class QueueUsingList<T> implements Queue<T> {
	Node<T> frontNode = null;
	Node<T> rearNode = null;

	/**
	 * Function to check if the queue is empty
	 * 
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
	public void push(T element) {
		Node<T> newNode = new Node<T>();
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
	public T pop() {
		T element = null;
		if (isEmpty()) {
			System.out.println("!!Stack is Empty!!");
		} else {
			Node<T> newNode = new Node<T>();
			newNode = frontNode;
			element = frontNode.data;
			frontNode = newNode.next;
			newNode.next = null;
		}
		return element;
	}

	/**
	 * Function to display element of queue
	 */
	public int show() {
		int count = 0;
		Node<T> traverse = new Node<T>();
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
