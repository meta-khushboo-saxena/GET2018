package com.metacube.training.daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.training.daoInterface.JobTitleDAO;
import com.metacube.training.model.JobTitle;

/**
* Job Title dao class
*/
@Repository
public class JobTitleDAOImpl implements JobTitleDAO {

	private JdbcTemplate jdbcTemplate;
	private final String SQL_INSERT_JOBTITLE = " INSERT INTO job_title(job_title) " + "VALUES " + "(?)";

	@Autowired
	public JobTitleDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public JobTitle getInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobTitle> getAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfo(JobTitle object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(JobTitle jobTitle) {
		return jdbcTemplate.update(SQL_INSERT_JOBTITLE, jobTitle.getJobTitle()) > 0;
	}

}
