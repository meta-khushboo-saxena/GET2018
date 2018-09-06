package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class for showing dependency injection for collection
 * @author user38
 *
 */
public class MainApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		JavaCollection collection = (JavaCollection) context.getBean(JavaCollection.class);

		collection.getAddressList();
		collection.getAddressSet();
		collection.getAddressMap();
	}
}
