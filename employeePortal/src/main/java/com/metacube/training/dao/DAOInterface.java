package com.metacube.training.dao;

import java.util.List;
/**
* Dao inteface class
*/
@SuppressWarnings("hiding")
public interface DAOInterface<Object> {

	/**
	* Function to get the information of the entity by id
	* @params id
	* @return object of the entity
	*/
	Object getInfoById(int id);

	/**
	* Function to get all the information the entity
	* @return object of the entity
	*/
	List<Object> getAllInfo();

	/**
	* Function to delete the information of the entity
	* @params id
	* @return boolean
	*/
	boolean deleteInfo(int id);

	/**
	* Function to update the information of the entity
	* @params object
	* @return boolean
	*/
	boolean updateInfo(Object object);

	/**
	* Function to create the data of the entity
	* @params object
	* @return boolean
	*/
	boolean create(Object object);

}
