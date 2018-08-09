package Algorithm1;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(KeyValuePair key) {
		root = insertWord(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertWord(Node root, KeyValuePair key) {

		if (root == null) {
			root = new Node(key);
		} else if (key.getkey().compareTo(root.keyValuePair.getkey()) < 0) {
			root.leftNode = insertWord(root.leftNode, key);
		} else if (key.getkey().compareTo(root.keyValuePair.getkey()) > 0) {
			root.rightNode = insertWord(root.rightNode, key);
		}
		return root;
	}

	/**
	 * Function to sort Inorder
	 * 
	 * @return list in sorted Inorder form
	 */
	List<KeyValuePair> sortInorder() {
		List<KeyValuePair> sortedList = new ArrayList<KeyValuePair>();
		inorderRec(root, sortedList);
		return sortedList;
	}

	/**
	 * Helper function to sortInorder for recursively sort
	 * 
	 * @param root
	 * @param sortedList
	 */
	void inorderRec(Node root, List<KeyValuePair> sortedList) {
		if (root != null) {
			inorderRec(root.leftNode, sortedList);
			sortedList.add(root.keyValuePair);
			inorderRec(root.rightNode, sortedList);
		}
	}

	/**
	 * Function to delete from the BST with the given key value
	 * 
	 * @param key
	 */
	void deleteKey(String key) {
		root = deleteRec(root, key);
	}

	/**
	 * Helper Function to recursively delete the value given by user
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	Node deleteRec(Node root, String key) {
		// Base condition If the tree is empty
		if (root == null)
			return root;

		// Otherwise, recur down the tree
		if (key.compareTo(root.keyValuePair.getkey()) < 0)
			root.leftNode = deleteRec(root.leftNode, key);
		else if (key.compareTo(root.keyValuePair.getkey()) > 0)
			root.rightNode = deleteRec(root.rightNode, key);

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.leftNode == null)
				return root.rightNode;
			else if (root.rightNode == null)
				return root.leftNode;

			// node with two children
			root.keyValuePair = minValue(root.rightNode);

			// Delete
			root.rightNode = deleteRec(root.rightNode, key);
		}

		return root;
	}

	/**
	 * Helper function for deletRec to check the minimum value to be assigned
	 * for the deleted node
	 * 
	 * @param root
	 * @return minimum key value pair
	 */
	KeyValuePair minValue(Node root) {
		KeyValuePair minv = root.keyValuePair;
		while (root.leftNode != null) {
			minv = root.leftNode.keyValuePair;
			root = root.leftNode;
		}
		return minv;
	}

	/**
	 * Function to search a entry in tree
	 * 
	 * @param key
	 * @return meaning or value for the entry
	 */
	public String search(String key) {

		root = searchRecursively(root, key);

		if (root != null) {
			return root.keyValuePair.getValue();
		}
		return "Element Not Found in Dictionary";
	}

	/**
	 * Helper function to recursively search the entry value
	 * 
	 * @param root
	 * @param key
	 * @return Node with the entry value found
	 */
	public Node searchRecursively(Node root, String key) {
		// Base Condition root is null or key is present at root
		if (root == null || root.keyValuePair.getkey().equalsIgnoreCase(key))
			return root;

		// value is less than root's key
		if (root.keyValuePair.getkey().compareTo(key) > 0)
			return searchRecursively(root.leftNode, key);

		// value is greater than root's key
		return searchRecursively(root.rightNode, key);

	}
}
