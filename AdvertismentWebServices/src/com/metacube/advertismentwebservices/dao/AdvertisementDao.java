package com.metacube.advertismentwebservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.advertismentwebservices.Common.ConnectionManager;
import com.metacube.advertismentwebservices.Properties.Query;
import com.metacube.advertismentwebservices.model.Advertisement;

/**
 * Class for performing insertion , deletion and updation operations on advertisement table
 */
public class AdvertisementDao{
	private static AdvertisementDao mysqlAdvertisementDao = new AdvertisementDao();

	/**
	 * Function to create singleton object
	 * @return object
	 */
	public static AdvertisementDao getInstance() {
		return mysqlAdvertisementDao;
	}
	
	/**
	 * Function to create new advertisement
	 * @param advertisement
	 */
	public void insert(Advertisement advertisement) {
		String query = Query.INSERT_NEW_ADVERTISEMENT;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, advertisement.getTitle());
			preparedStatement.setString(2, advertisement.getDescription());
			preparedStatement.setInt(3, advertisement.getCategory_id());
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Function to select all the advertisements
	 * @return list of advertisement
	 */
	public List<Advertisement> getAll() {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		String query = Query.SELECT_ALL_ADVERTISMENT;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Advertisement advertisement = new Advertisement();
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertisementList;
	}

	/**
	 * Function to select advertisement list by id
	 * @param id
	 * @return list of advertisement
	 */
	public List<Advertisement> getAllById(int id) {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		String query = Query.SELECT_ALL_ADVERTISMENT_BY_ID;
		ResultSet resultSet = null;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Advertisement advertisement = new Advertisement();
			while (resultSet.next()) {
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertisementList;
	}

	/**
	 * Function to update the name of the advertisement
	 * @param name
	 * @param id
	 */
	public void updateName(String name, int id) {
		String query = Query.UPDATE_NAME;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Function to delete the advertisement by id
	 * @param id
	 */
	public void deleteAdvertisement(int id) {
		String query = Query.DELETE_ADVERTISEMENT;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
