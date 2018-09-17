package com.metacube.training.daoInterface;

import java.util.List;

@SuppressWarnings("hiding")
public interface BaseDAO<Object> {

	public Object getInfoById(int id);

	public List<Object> getAllInfo();

	public boolean create(Object entity);

	public boolean updateInfo(Object t);

	public boolean deleteInfo(int id);
}