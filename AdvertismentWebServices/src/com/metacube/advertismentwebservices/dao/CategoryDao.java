package com.metacube.advertismentwebservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertismentwebservices.Common.ConnectionManager;
import com.metacube.advertismentwebservices.Properties.Query;
import com.metacube.advertismentwebservices.model.Category;

/**
 * Class for performing insertion , deletion and updation operations on category table
 */
public class CategoryDao {

	private static CategoryDao mysqlCategoryDao = new CategoryDao();

	/**
	 * Function to create singleton object
	 * @return
	 */
	public static CategoryDao getInstance() {
		return mysqlCategoryDao;
	}

	/**
	 * Function to select all the categories
	 * @return list of categories
	 */
	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<Category>();
		String query = Query.SELECT_ALL_CATEGORIES;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("category"));
				categoryList.add(category);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}

	/**
	 * Function to insert the data in the category table
	 * @param name
	 */
	public void insert(String name) {
		String query = Query.INSERT_NEW_CATEGORY;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Function to update the name of the category
	 * @param name
	 * @param id
	 */
	public void updateCategory(String category, int id) {
		String query = Query.UPDATE_CATEGORY;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
