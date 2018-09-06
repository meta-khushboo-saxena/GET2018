package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public TextEditor textEditor(SpellChecker spellChecker) {
		return new TextEditor(spellChecker);
	}

	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker("Good");
	}
}
