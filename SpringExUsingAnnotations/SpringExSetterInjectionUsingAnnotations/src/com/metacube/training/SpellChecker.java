package com.metacube.training;
/**
 * Class spell checker
 */
public class SpellChecker {
	private String word;

	 public void setWord(String word) {
		 this.word=word;
	 }
	
	public String getWord() {
		return word;
	}

	/**
	 * Function to show words
	 */
	public void checkSpelling() {
		System.out.println("checkSpelling " + getWord());
	}
}
