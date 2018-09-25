package com.metacube.training.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.JobTitleRepository;
import com.metacube.training.serviceInterface.JobTitleServiceInterface;

/**
 * Job Title Service class to provide interface between Controller and dao
 */
@Service
public class JobTitleServiceImplement implements JobTitleServiceInterface {

	@Autowired
	private JobTitleRepository<JobTitle> jobTitleRepository;

	@Override
	public boolean create(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		return true;
	}
}
