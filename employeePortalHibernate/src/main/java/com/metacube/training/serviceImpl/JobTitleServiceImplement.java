package com.metacube.training.serviceImpl;

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
	public boolean create(JobTitle jobTitle) {
		return jobTitleDAO.create(jobTitle);
	}
}
