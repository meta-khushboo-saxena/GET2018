package com.metacube.training.daoImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.daoInterface.JobTitleDAO;
import com.metacube.training.model.JobTitle;

/**
 * Job Title dao class
 */
@Repository
@Transactional
public class JobTitleDAOImpl implements JobTitleDAO {

	@Autowired
	private SessionFactory sessionFactory;

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
	public boolean create(JobTitle jobTitle) {
		if (sessionFactory.getCurrentSession().save(jobTitle) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateInfo(JobTitle t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
