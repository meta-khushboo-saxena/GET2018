package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Text Editor class
 */
public class TextEditor {

	@Autowired
	private SpellChecker spellChecker1;
	@Autowired
	private SpellChecker spellChecker2;

	/**
	 * constructor method to inject the dependency.
	 * 
	 * @param spellChecker1
	 */
	@Autowired
	public TextEditor(SpellChecker spellChecker1) {
		this.spellChecker1 = spellChecker1;
	}

	public SpellChecker getSpellChecker1() {
		return spellChecker1;
	}

	@Autowired
	public void setSpellChecker2(SpellChecker spellChecker2) {
		this.spellChecker2 = spellChecker2;
	}

	public SpellChecker getSpellChecker2() {
		return spellChecker2;
	}

	/**
	 * Function to show the spell checker
	 */
	public void spellCheck() {
		spellChecker1.checkSpelling();
		spellChecker2.checkSpelling();
	}
}