package Stack;

public class StackUsingArray implements Stack {

	public int stack[];
	public int top = -1;

	/**
	 * Constructor to initialize the size of stack 
	 * @param size
	 */
	public StackUsingArray(int size) {
		stack = new int[size];
	}

	/**
	 * Function to check if the stack is full
	 * 
	 * @return true if stack is full
	 */
	public boolean isFull() {
		boolean flag = false;
		if (top == stack.length - 1) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * Function to check if the stack is empty
	 * 
	 * @return true if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean flag = false;
		if (top == -1) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to insert an elements in the stack
	 */
	@Override
	public void push(int number) {
		if (isFull()) {
			System.out.println("Stack Overflow!!");
		} else {
			top++;
			stack[top] = number;
		}
	}

	/**
	 * Function to delete an element from stack
	 */
	@Override
	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow!!");
		} else {
			top--;
		}
	}

	/**
	 * Function to display elements of stack and return count
	 */
	@Override
	public int show() {
		int count = 0;
		System.out.println("\nElements in stack are:");
		for (int i = 0; i <= top; i++) {
			System.out.println(stack[i]);
			count++;
		}
		return count;
	}
}
