package com.metacube.training.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.daoInterface.JobTitleDAO;
import com.metacube.training.model.JobTitle;
import com.metacube.training.serviceInterface.JobTitleServiceInterface;

/**
 * Job Title Service class to provide interface between Controller and dao
 */
@Service
public class JobTitleServiceImplement implements JobTitleServiceInterface {

	@Autowired
	private JobTitleDAO jobTitleDAO;

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
		return jobTitleDAO.create(jobTitle);
	}

}
