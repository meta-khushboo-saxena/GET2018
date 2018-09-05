package com.metacube.training;

public class TextEditor {

	private SpellChecker spellChecker1;
	private SpellChecker spellChecker2;

	// a constructor method to inject the dependency.
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

	public void spellCheck() {
		spellChecker1.checkSpelling();
		spellChecker2.checkSpelling();
	}
}