package com.metacube.training;

/**
 * Text Editor class
 */
public class TextEditor {

	private SpellChecker spellChecker1;
	private SpellChecker spellChecker2;

	/**
	 * constructor method to inject the dependency.
	 * 
	 * @param spellChecker1
	 */
	public TextEditor(SpellChecker spellChecker1) {
		this.spellChecker1 = spellChecker1;
	}

	public SpellChecker getSpellChecker1() {
		return spellChecker1;
	}

	public void setSpellChecker2(SpellChecker spellChecker2) {
		this.spellChecker2 = spellChecker2;
	}

	public SpellChecker getSpellChecker2() {
		return spellChecker2;
	}

	/**
	 * Function to show the spellchecker
	 */
	public void spellCheck() {
		spellChecker1.checkSpelling();
		spellChecker2.checkSpelling();
	}
}
