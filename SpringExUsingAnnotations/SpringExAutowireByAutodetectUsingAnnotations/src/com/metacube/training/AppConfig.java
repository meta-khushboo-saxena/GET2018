package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public TextEditor textEditor(SpellChecker spellChecker1) {
		TextEditor textEditor = new TextEditor(spellChecker1);
		textEditor.setSpellChecker2(spellChecker2());
		return textEditor;
	}

	@Bean
	public SpellChecker spellChecker1() {
		return new SpellChecker("Good");
	}

	@Bean
	public SpellChecker spellChecker2() {
		return new SpellChecker("Poor");
	}
}
