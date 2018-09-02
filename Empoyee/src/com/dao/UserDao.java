package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.dao.Queries;
import com.model.UserDetail;

public class UserDao {

	private static UserDao userDao = new UserDao();
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public static UserDao getInstance() {
		return userDao;
	}

	public List<UserDetail> selectUserDetail() {
		UserDetail userDetail;
		List<UserDetail> userList = new ArrayList<UserDetail>();
		try {
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(Queries.selectQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userDetail = new UserDetail();
				userDetail.setFirstName(resultSet.getString("first_name"));
				userDetail.setLastName(resultSet.getString("last_name"));
				userDetail.setAge(resultSet.getInt("age"));
				userDetail.setDateOfBirth(resultSet.getDate("date_of_birth"));
				userDetail.setContact(resultSet.getString("contact"));
				userDetail.setEmail(resultSet.getString("email"));
				userDetail.setPassword(resultSet.getString("password"));
				userDetail.setOrganization(resultSet.getString("organisation"));

				userList.add(userDetail);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				// Close ResultSet
				if (resultSet != null) {
					resultSet.close();
				}
				// Close Prepared Statement Object
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				// Close Connection Object
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	public void insertUserDetail(UserDetail userDetail) {
		// adding the details in the database
		try {
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(Queries.insertQuery);
			preparedStatement.setString(1, userDetail.getFirstName());
			preparedStatement.setString(2, userDetail.getLastName());
			preparedStatement.setInt(3, userDetail.getAge());
			preparedStatement.setDate(4, userDetail.getDateOfBirth());
			preparedStatement.setString(5, userDetail.getEmail());
			preparedStatement.setString(6, userDetail.getPassword());
			preparedStatement.setString(7, userDetail.getOrganization());
			preparedStatement.setString(8, userDetail.getContact());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				// Close Prepared Statement Object
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				// Close Connection Object
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateUserDetail(UserDetail userDetail) {

		try {
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(Queries.updateQuery);
			preparedStatement.setString(1, userDetail.getFirstName());
			preparedStatement.setString(2, userDetail.getLastName());
			preparedStatement.setInt(3, userDetail.getAge());
			preparedStatement.setDate(4, userDetail.getDateOfBirth());
			preparedStatement.setString(5, userDetail.getOrganization());
			preparedStatement.setString(6, userDetail.getContact());
			preparedStatement.setString(7, userDetail.getEmail());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				// Close Prepared Statement Object
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				// Close Connection Object
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateImage(UserDetail userDetail) {

		try {
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(Queries.updateImageQuery);
			preparedStatement.setString(1, userDetail.getImage());
			preparedStatement.setString(2, userDetail.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				// Close Prepared Statement Object
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				// Close Connection Object
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UserDetail selectUserDetailByEmail(String email) {
		UserDetail userDetail = new UserDetail();

		try {
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(Queries.searchQueryByEmail);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();

			userDetail.setFirstName(resultSet.getString("first_name"));
			userDetail.setLastName(resultSet.getString("last_name"));
			userDetail.setAge(resultSet.getInt("age"));
			userDetail.setDateOfBirth(resultSet.getDate("date_of_birth"));
			userDetail.setContact(resultSet.getString("contact"));
			userDetail.setImage(resultSet.getString("image"));
			userDetail.setEmail(resultSet.getString("email"));
			userDetail.setPassword(resultSet.getString("password"));
			userDetail.setOrganization(resultSet.getString("organisation"));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				// Close ResultSet
				if (resultSet != null) {
					resultSet.close();
				}
				// Close Prepared Statement Object
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				// Close Connection Object
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userDetail;
	}

	public List<UserDetail> selectFriendList(String email) {
		UserDetail userDetail;
		List<UserDetail> userList = new ArrayList<UserDetail>();

		try {
			connection = ConnectionManager.getConnection();
			preparedStatement = connection.prepareStatement(Queries.selectQueryForFriend);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, email);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userDetail = new UserDetail();
				userDetail.setId(resultSet.getInt("id"));
				userDetail.setFirstName(resultSet.getString("first_name"));
				userDetail.setLastName(resultSet.getString("last_name"));
				userDetail.setAge(resultSet.getInt("age"));
				userDetail.setDateOfBirth(resultSet.getDate("date_of_birth"));
				userDetail.setContact(resultSet.getString("contact"));
				userDetail.setEmail(resultSet.getString("email"));
				userDetail.setPassword(resultSet.getString("password"));
				userDetail.setOrganization(resultSet.getString("organisation"));
				userList.add(userDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				// Close ResultSet
				if (resultSet != null) {
					resultSet.close();
				}
				// Close Prepared Statement Object
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				// Close Connection Object
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	// public void deleteUserDetail(UserDetail userDetail) {
	//
	// }
}