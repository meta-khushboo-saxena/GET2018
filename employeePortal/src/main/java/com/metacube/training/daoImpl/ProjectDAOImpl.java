package com.metacube.training.daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.training.daoInterface.ProjectDAO;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.ProjectMaster;

/**
* Project Master dao class
*/
@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//Queries for performing various operations on project
	private final String SQL_INSERT_PROJECT = "insert into project_master(name, description, start_date, end_date, project_logo) values(?,?,?,?,?)";
	private final String SQL_GET_ALL = "SELECT * FROM project_master ";
	private final String SQL_FIND_PROJECT = "SELECT * FROM project_master WHERE project_id = ?";
	private final String SQL_DELETE_PROJECT = "delete from project_master where project_id = ?";
	private final String SQL_UPDATE_PROJECT = "UPDATE project_master SET name = ? , description = ? , start_date = ? , end_date = ? , project_logo = ?"
			+ " WHERE project_id = ?";
	
	@Override
	public ProjectMaster getInfoById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PROJECT,
				new Object[] { id }, new ProjectMapper());
	}

	@Override
	public List<ProjectMaster> getAllInfo() {
		return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
	}

	@Override
	public boolean deleteInfo(int id) {
		return jdbcTemplate.update(SQL_DELETE_PROJECT, id) > 0;
	}

	@Override
	public boolean updateInfo(ProjectMaster project) {
		return jdbcTemplate.update(SQL_UPDATE_PROJECT, project.getName(),
				project.getDescription(), project.getStartDate(),
				project.getEndDate(), project.getProjectLogo(),
				project.getProjectId()) > 0;
	}

	@Override
	public boolean create(ProjectMaster project) {
		return jdbcTemplate.update(SQL_INSERT_PROJECT, project.getName(),
				project.getDescription(), project.getStartDate(),
				project.getEndDate(), project.getProjectLogo()) > 0;
	}


}
