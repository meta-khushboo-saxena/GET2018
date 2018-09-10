package com.metacube.training.dao;

import java.util.List;
/**
* Dao inteface class
*/
@SuppressWarnings("hiding")
public interface DAOInterface<Object> {

	Object getInfoById(int id);

	List<Object> getAllInfo();

	boolean deleteInfo(int id);

	boolean updateInfo(Object object);

	boolean create(Object object);

}
