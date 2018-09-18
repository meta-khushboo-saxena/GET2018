package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.model.ProjectMaster;

/**
* Class to map the data from database to project model
*/
public class ProjectMapper implements RowMapper<ProjectMaster> {

	public ProjectMaster mapRow(ResultSet resultSet, int i) throws SQLException {

		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectId(resultSet.getInt("project_id"));
		projectMaster.setName(resultSet.getString("name"));
		projectMaster.setDescription(resultSet.getString("description"));
		projectMaster.setStartDate(resultSet.getDate("start_date"));
		projectMaster.setEndDate(resultSet.getDate("end_date"));
		projectMaster.setProjectLogo(resultSet.getString("project_logo"));
		
		return projectMaster;
	}
}
