package Stack;

import Node.Node;

public class StackUsingLinkList implements Stack {
	Node Top = null;

	/**
	 * Function to check if the stack is empty 
	 * @return true if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean flag = false;
		if (Top == null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to insert an elements in the stack
	 */
	@Override
	public void push(int element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = Top;
		Top = newNode;
	}

	/**
	 * Function to delete an element from stack
	 */
	@Override
	public void pop() {
		Node delete = new Node();

		if (isEmpty()) {
			System.out.println("Stack UnderFlow");
		} else {
			delete = Top;
			delete.data = Top.data;
			Top = Top.next;
			delete = null;
		}
	}

	/**
	 * Function to display elements of stack and return count
	 */
	@Override
	public int show() {
		int count = 0;
		if (Top == null) {
			System.out.println("Stack is Empty");
		} else {
			Node traverse = Top;
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
