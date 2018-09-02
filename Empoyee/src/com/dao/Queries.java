package com.dao;

/**
 * Class containing all queries
 */
public class Queries {

	public static final String insertQuery = "INSERT INTO user_detail(first_name,last_name,age,date_of_birth,email,password,organisation,contact)VALUES"
			+ " (?,?,?,?,?,?,?,?) ";
	public static final String selectQuery = "SELECT * FROM user_detail";
	public static final String searchQueryByEmail = "SELECT * FROM user_detail WHERE email = ?";
	public static final String selectQueryForFriend = "SELECT * FROM user_detail WHERE organisation IN ( SELECT organisation  from user_detail "
	+ " where email = ? ) AND email <> ? ;";
	public static final String updateQuery = "UPDATE user_detail SET first_name = ? , last_name = ? ,age = ?, date_of_birth = ?, organisation = ? , contact = ? "
			+ " WHERE email = ?";
	public static final String updateImageQuery = "UPDATE user_detail SET image = ? WHERE email = ? ";

} 