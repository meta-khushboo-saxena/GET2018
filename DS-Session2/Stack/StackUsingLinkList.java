package Stack;

import Queue.Node;

public class StackUsingLinkList<T> implements Stack<T> {
	public Node<T> top = null;

	/**
	 * Function to check if the stack is empty
	 * 
	 * @return true if stack is empty
	 */
	public boolean isEmpty() {
		boolean flag = false;
		if (top == null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to insert an elements in the stack
	 */
	public void push(T element) {
		Node<T> newNode = new Node<T>();
		newNode.data = element;
		newNode.next = top;
		top = newNode;
	}

	/**
	 * Function to delete an element from stack
	 */
	public T pop() {
		Node<T> delete = new Node<T>();
		T data = null;
		if (isEmpty()) {
			System.out.println("Stack UnderFlow");
		} else {
			delete = top;
			data = top.data;
			top = delete.next;
		}
		return data;
	}

	/**
	 * Function to return the element from top of stack
	 */
	public T peek() {

		if (!isEmpty()) {
			T element = top.data;
			return element;
		}
		return null;
	}

	/**
	 * Function to display elements of stack and return count
	 */
	public int show() {
		int count = 0;
		if (top == null) {
			System.out.println("Stack is Empty");
		} else {
			Node<T> traverse = top;
			System.out.println("\nElements in stack using Link List:");
			while (traverse != null) {
				System.out.println(traverse.data);
				count++;
				traverse = traverse.next;
			}
		}
		return count;
	}
}
