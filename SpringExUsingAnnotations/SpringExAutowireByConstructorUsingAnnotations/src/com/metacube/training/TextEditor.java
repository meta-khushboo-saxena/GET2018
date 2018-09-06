package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

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
	@Autowired(required=false)
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