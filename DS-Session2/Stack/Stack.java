package Stack;

public interface Stack<T> {

	public void push(T element);

	public T pop();

	public boolean isEmpty();

	public T peek();
	
	public int show();

}
