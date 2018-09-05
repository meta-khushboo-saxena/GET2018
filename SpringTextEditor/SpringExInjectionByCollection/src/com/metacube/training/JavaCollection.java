package com.metacube.training;

import java.util.*;

public class JavaCollection {
   List<String> addressList;
   Set<String>  addressSet;
   Map<String,String>  addressMap;
   Properties addressProp;

   public void setAddressList(List<String> addressList) {
      this.addressList = addressList;
   }
   
   // prints and returns all the elements of the list.
   public List<String> getAddressList() {
      System.out.println("List Elements :"  + addressList);
      return addressList;
   }
   
   public void setAddressSet(Set<String> addressSet) {
      this.addressSet = addressSet;
   }
   
   // prints and returns all the elements of the Set.
   public Set<String> getAddressSet() {
      System.out.println("Set Elements :"  + addressSet);
      return addressSet;
   }
   
   public void setAddressMap(Map<String, String> addressMap) {
      this.addressMap = addressMap;
   }
   
   // prints and returns all the elements of the Map.
   public Map<String, String> getAddressMap() {
      System.out.println("Map Elements :"  + addressMap);
      return addressMap;
   }
}
