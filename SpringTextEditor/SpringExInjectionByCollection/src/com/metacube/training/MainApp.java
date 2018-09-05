package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   @SuppressWarnings("resource")
public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      JavaCollection collection=(JavaCollection)context.getBean("javaCollection");

      collection.getAddressList();
      collection.getAddressSet();
      collection.getAddressMap();
   }
}
