package com.metacube.training.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import org.springframework.stereotype.Repository;

import com.metacube.training.model.ProjectMaster;
import com.metacube.training.util.ConnectionManager;

/**
 * Project Master dao class
 */
@Repository
public class ProjectDAO implements DAOInterface<ProjectMaster> {

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	// Queries for performing various operations on project
	private final String SQL_INSERT_PROJECT = "insert into project_master(name, description, start_date, end_date, project_logo) values(?,?,?,?,?)";
	private final String SQL_GET_ALL = "SELECT * FROM project_master ";
	private final String SQL_FIND_PROJECT = "SELECT * FROM project_master WHERE project_id = ?";
	private final String SQL_DELETE_PROJECT = "delete from project_master where project_id = ?";
	private final String SQL_UPDATE_PROJECT = "UPDATE project_master SET name = ? , description = ? , start_date = ? , end_date = ? , project_logo = ?"
			+ " WHERE project_id = ?";

	@Override
	public boolean create(ProjectMaster project) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_INSERT_PROJECT);) {
			try {
				statement.setString(1, project.getName());
				statement.setString(2, project.getDescription());
				statement.setDate(3, project.getStartDate());
				statement.setDate(4, project.getEndDate());
				statement.setString(5, project.getProjectLogo());
				statement.executeUpdate();
				return true;
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public ProjectMaster getInfoById(int id) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_FIND_PROJECT);) {
			try {
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();

				ProjectMaster projectMaster = new ProjectMaster();
				projectMaster.setProjectId(resultSet.getInt("project_id"));
				projectMaster.setName(resultSet.getString("name"));
				projectMaster.setDescription(resultSet.getString("description"));
				projectMaster.setStartDate(resultSet.getDate("start_date"));
				projectMaster.setEndDate(resultSet.getDate("end_date"));
				projectMaster.setProjectLogo(resultSet.getString("project_logo"));

				return projectMaster;

			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<ProjectMaster> getAllInfo() {
		List<ProjectMaster> projectList = new ArrayList<ProjectMaster>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_GET_ALL);) {
			try {
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {

					ProjectMaster projectMaster = new ProjectMaster();
					projectMaster.setProjectId(resultSet.getInt("project_id"));
					projectMaster.setName(resultSet.getString("name"));
					projectMaster.setDescription(resultSet.getString("description"));
					projectMaster.setStartDate(resultSet.getDate("start_date"));
					projectMaster.setEndDate(resultSet.getDate("end_date"));
					projectMaster.setProjectLogo(resultSet.getString("project_logo"));

					projectList.add(projectMaster);
				}
				return projectList;

			} catch (SQLException ex) {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public boolean deleteInfo(int id) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_DELETE_PROJECT);) {
			try {
				statement.setInt(1, id);
				statement.executeUpdate();
				return true;
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean updateInfo(ProjectMaster project) {

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(SQL_UPDATE_PROJECT);) {
			try {
				statement.setString(1, project.getName());
				statement.setString(2, project.getDescription());
				statement.setDate(3, project.getStartDate());
				statement.setDate(4, project.getEndDate());
				statement.setString(5, project.getProjectLogo());
				statement.setInt(6, project.getProjectId());
				statement.executeUpdate();

				return true;
			} catch (SQLException ex) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

}
