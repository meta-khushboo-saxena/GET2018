package com.metacube.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public JavaCollection javaCollection(){
		JavaCollection javaCollection = new JavaCollection();
		List<String> addressList = new ArrayList<String>();
		addressList.add("INDIA");
		addressList.add("PAKISTAN");
		addressList.add("USA");
		addressList.add("USA");
		
		javaCollection.setAddressList(addressList);
		
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("INDIA");
		addressSet.add("PAKISTAN");
		addressSet.add("USA");
		addressSet.add("USA");
		javaCollection.setAddressSet(addressSet);
		
		Map<String,String> addressMap = new HashMap<String,String>();
		addressMap.put("1","INDIA");
		addressMap.put("2","PAKISTAN");
		addressMap.put("3","USA");
		addressMap.put("4","USA");
		javaCollection.setAddressMap(addressMap);
		
		return javaCollection;
	}
}
