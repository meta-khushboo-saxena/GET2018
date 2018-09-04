package com.metacube.advertismentwebservices.facade;

import java.util.List;

import com.metacube.advertismentwebservices.Common.Status;
import com.metacube.advertismentwebservices.dao.CategoryDao;
import com.metacube.advertismentwebservices.dao.CategoryDao;
import com.metacube.advertismentwebservices.model.Category;

/**
 * Facade class for Category
 */
public class CategoryFacade {

	private static CategoryFacade categoryFacade = new CategoryFacade();

	CategoryDao categoryDao = (CategoryDao) CategoryDao.getInstance();

	/**
	 * Class to create singleton object
	 * 
	 * @return object
	 */
	public static CategoryFacade getInstance() {
		return categoryFacade;
	}

	/**
	 * Function to return status for insertion
	 * 
	 * @param name
	 * @return status
	 */
	public Status insertCategory(String name) {
		List<Category> categoryList = categoryDao.getAll();

		for (Category category : categoryList) {
			if (category.getName().equals(name)) {
				return Status.DUPLICATE;
			}
		}
		categoryDao.insert(name);
		return Status.INSERTED;
	}

	/**
	 * Function to return the list of category
	 * 
	 * @return
	 */
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	/**
	 * Function to return the status for updated
	 * 
	 * @param category
	 * @param id
	 * @return status
	 */
	public Status updateCategory(String category, int id) {
		categoryDao.updateCategory(category, id);
		return Status.UPDATED;
	}
}
