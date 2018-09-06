package com.metacube.training;

import java.util.*;

/**
 * Class to inject dependency for different type of collection
 * 
 * @author user38
 *
 */
public class JavaCollection {
	List<String> addressList;
	Set<String> addressSet;
	Map<String, String> addressMap;
	Properties addressProp;

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	/**
	 * prints and returns all the elements of the list.
	 * 
	 * @return list
	 */
	public List<String> getAddressList() {
		System.out.println("List Elements :" + addressList);
		return addressList;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}

	/**
	 * prints and returns all the elements of the Set.
	 * 
	 * @return set
	 */
	public Set<String> getAddressSet() {
		System.out.println("Set Elements :" + addressSet);
		return addressSet;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}

	/**
	 * prints and returns all the elements of the Map.
	 * 
	 * @return map
	 */
	public Map<String, String> getAddressMap() {
		System.out.println("Map Elements :" + addressMap);
		return addressMap;
	}
}
