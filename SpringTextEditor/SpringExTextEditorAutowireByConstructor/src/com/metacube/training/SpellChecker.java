package com.metacube.training;

/**
 * Class spell checker
 */
public class SpellChecker {
	private String word;

	public SpellChecker(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	/**
	 * Function to check spelling
	 */
	public void checkSpelling() {
		System.out.println("checkSpelling " + getWord());
	}
}
