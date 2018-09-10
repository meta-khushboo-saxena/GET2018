package com.metacube.training.service;

import java.util.List;

@SuppressWarnings("hiding")
public interface ServiceInterface<Object> {

	Object getInfoById(int id);

	List<Object> getAllInfo();

	boolean deleteInfo(int id);

	boolean updateInfo(Object object);

	boolean create(Object object);

}
