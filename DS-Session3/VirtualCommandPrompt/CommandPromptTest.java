package VirtualCommandPrompt;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandPromptTest {
	Node parent = new Node("Root");
	@Test
	public void testCreateDirectory() {
		CommandPrompt prompt = new CommandPrompt();
		boolean result = prompt.createDirectory("com", parent);

		assertEquals(true, result);
	}
	
	@Test
	public void testChangeDirectory() {
		CommandPrompt prompt = new CommandPrompt();
		prompt.createDirectory("metacube", parent);
		boolean result = prompt.changeDirectory("metacube",parent);

		assertEquals(true, result);
	}

}
