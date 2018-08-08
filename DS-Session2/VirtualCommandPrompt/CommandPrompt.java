package VirtualCommandPrompt;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Class Command prompt
 */
public class CommandPrompt {
	private static Scanner scan = new Scanner(System.in);

	private Node root = new Node("Root");
	private Node current;

	/**
	 * Function to create new Directory
	 * 
	 * @param directory
	 * @param parent
	 */
	public boolean createDirectory(String directory, Node parent) {
		Node child = new Node(directory, parent);
		parent.addChild(child);
		return true;
	}

	/**
	 * Function to move from one directory to other
	 * 
	 * @param directory
	 * @return
	 */
	public boolean changeDirectory(String directory, Node parent) {

		List<Node> childList = parent.getChildren();

		Iterator<Node> iterateChild = childList.iterator();

		while (iterateChild.hasNext()) {
			Node child = iterateChild.next();

			if (child.getName().equals(directory)) {
				current = child;
				return true;
			}
		}
		return false;
	}

	/**
	 * Function to move back to parent Directory
	 * 
	 * @return
	 */
	public boolean backToParent(Node parent) {
		try {
			if (!parent.getParent().equals(null)) {
				this.current = this.current.getParent();
				return true;
			}
		} catch (NullPointerException e) {
			System.out.println("Already on root directory");
		}
		return false;
	}

	/**
	 * Function to generate the list of all directories
	 * 
	 * @return
	 */
	public boolean listDirectories(Node parent) {
		if (!parent.isLeaf()) {
			List<Node> childList = parent.getChildren();
			Iterator<Node> iterateChild = childList.iterator();

			while (iterateChild.hasNext()) {
				Node child = iterateChild.next();

				System.out.println(child.getDate() + "    " + child.getName());
			}
			return true;
		}
		return false;
	}

	/**
	 * Function to check if the directory is present in the parent directory
	 * 
	 * @param parent
	 * @param directory
	 */
	public void checkDirectories(Node parent, String directory) {

		List<Node> childList = parent.getChildren();
		Iterator<Node> iterateChild = childList.iterator();

		while (iterateChild.hasNext()) {
			Node child = iterateChild.next();
			if (!child.isLeaf()) {
				checkDirectories(child, directory);
			} else {
				if (child.getName().equals(directory)) {
					System.out.println("name : " + directory);
				}
			}
		}
	}

	/**
	 * Function to find the directory
	 * 
	 * @param directory
	 * @return true if directory is found
	 */
	public Boolean findDirectories(String directory,Node parent) {
		checkDirectories(parent, directory);
		return true;
	}

	/**
	 * Function to generate tree of root node
	 * 
	 * @param parent
	 */
	public void directoryTree(Node parent) {
		List<Node> childList = parent.getChildren();
		Iterator<Node> iterateChild = childList.iterator();

		while (iterateChild.hasNext()) {
			Node child = iterateChild.next();
			System.out.print("|___" + child.getName());
			if (!child.isLeaf()) {
				directoryTree(child);
			} else {
				System.out.println();
			}
		}
	}

	/**
	 * Function to check if tree can be generate
	 * 
	 * @return true if the tree can be generated
	 */
	public Boolean createTree(Node parent) {
		directoryTree(parent);
		return true;
	}

	public static void main(String arg[]) {

		CommandPrompt prompt = new CommandPrompt();

		prompt.current = prompt.root;
		String value[], command;

		// current path is root
		String path = prompt.root.getName() + ":/";

		do {

			System.out.print(path + ">");
			command = scan.nextLine();
			value = command.split(" ");

			switch (value[0]) {
			case "mkdir": {
				prompt.createDirectory(value[1], prompt.current);
				break;
			}
			case "cd": {
				if (prompt.changeDirectory(value[1], prompt.current)) {
					path = path + "/" + value[1];
				} else {
					System.out.println("No such directory found");
				}
				break;
			}
			case "bk": {

				if (prompt.backToParent(prompt.current)) {

					String newPath[] = path.split("/");
					String newLocationPath = "";
					int i = 0;

					while (i < newPath.length - 1) {
						newLocationPath = newLocationPath + newPath[i] + "/";
						i++;
					}

					path = newLocationPath;
				}
				break;
			}
			case "ls": {
				if (!prompt.listDirectories(prompt.current)) {
					System.out.println("At last of the directories");
				}
				break;
			}
			case "find": {
				if (!prompt.findDirectories(value[1],prompt.current)) {
					System.out.println("At last of the directories");
				}
				break;
			}
			case "tree": {
				if (!prompt.createTree(prompt.current)) {
					System.out.println("at last of the directories");
				}
				break;
			}
			case "exit": {
				System.exit(0);
			}
			default:
				System.out.println("Invalid Command!!");
			}
		} while (true);
	}
}
