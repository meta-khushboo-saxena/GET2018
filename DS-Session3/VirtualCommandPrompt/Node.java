package VirtualCommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Node {

	private List<Node> childDirectory = new ArrayList<Node>();
	private Node parentDirectory = null;
	private String name = null;
	private Date date;

	/**
	 * Constructor to initialize the root directory
	 * 
	 * @param name
	 */
	public Node(String name) {
		this.name = name;
		this.date = new Date();
	}

	/**
	 *  Constructor to initialize sub- directories
	 * @param name
	 * @param parent
	 */
	public Node(String name, Node parent) {
		this.name = name;
		this.parentDirectory = parent;
		this.date = new Date();
	}

	/**
	 *  list of children or sub-directories of a directory
	 * @return
	 */
	public List<Node> getChildren() {
		return childDirectory;
	}

	/**
	 *  Add child to directory
	 * @param child
	 */
	public void addChild(Node child) {

		this.childDirectory.add(child);
	}

	/**
	 * get the name of directory
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 *  check if the directory is root directory
	 * @return
	 */
	public boolean isRoot() {
		return (this.parentDirectory == null);
	}

	/**
	 * check if the directory is leaf directory
	 * @return
	 */
	public boolean isLeaf() {
		return this.childDirectory.size() == 0;
	}

	/**
	 * get the parent directory
	 * @return
	 */
	public Node getParent() {
		return this.parentDirectory;
	}

	/**
	 * get date of creation of directory
	 * @return
	 */
	public Date getDate() {
		return this.date;
	}
}