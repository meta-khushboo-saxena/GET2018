package Queue;

/**
 * Interface of Queue of generic type
 *
 * @param <T>
 */
public interface Queue<T> {

	public void push(T element);

	public T pop();

	public boolean isEmpty();

	public int show();
}
