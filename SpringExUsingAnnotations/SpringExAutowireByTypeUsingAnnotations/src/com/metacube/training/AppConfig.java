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
	public SpellChecker spellChecker() {
		SpellChecker spellChecker = new SpellChecker();
		spellChecker.setWord("Good");
		return spellChecker;
	}
}
