package com.metacube.training;

/**
 * Class for text editor
 */
public class TextEditor {

	private SpellChecker spellChecker;

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	/**
	 * Function to call function of spell checker
	 */
	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}