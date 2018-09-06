package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public TextEditor textEditor() {
		return new TextEditor();
	}

	@Bean
	public SpellChecker spellChecker1() {
		SpellChecker spellChecker = new SpellChecker();
		spellChecker.setWord("Good");
		return spellChecker;
	}

	@Bean
	public SpellChecker spellChecker2() {
		SpellChecker spellChecker = new SpellChecker();
		spellChecker.setWord("Weak");
		return spellChecker;
	}

	@Bean
	public SpellChecker spellChecker3() {
		SpellChecker spellChecker = new SpellChecker();
		spellChecker.setWord("Poor");
		return spellChecker;
	}
}
