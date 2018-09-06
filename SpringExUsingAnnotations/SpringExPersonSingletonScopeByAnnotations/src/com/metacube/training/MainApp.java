package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person = (Person) context.getBean(Person.class);
		person.checkType();
		person.setType("Admin");
		person.checkType();
		Person otherPerson = (Person) context.getBean(Person.class);
		otherPerson.checkType();
	}
}