package com.metacube.training;

/**
 * Class for text editor
 */
public class TextEditor {
	private SpellChecker spellChecker1;

	/**
	 * a constructor method to inject the dependency.
	 * 
	 * @param spellChecker1
	 */
	public TextEditor(SpellChecker spellChecker1) {
		this.spellChecker1 = spellChecker1;
	}

	/**
	 * Fuction to call spell checker function
	 */
	public void spellCheck() {
		spellChecker1.checkSpelling();
	}
}
