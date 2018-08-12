package NestedList;

import java.util.List;

/**
 * Interface for representing a nested list
 */
public interface NestedList {

	public int getSum(List<Object> list);

	public int getLargest(List<Object> list);

	public boolean search(int value, List<Object> list);

	public int getValue(String pattern, List<Object> list);
}
