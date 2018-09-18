package com.metacube.training.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.ProjectMaster;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.serviceInterface.ProjectServiceInterface;

/**
 * Project Service class to provide interface between Controller and dao
 */
@Service
public class ProjectServiceImplement implements ProjectServiceInterface {

	@Autowired
	private ProjectRepository<ProjectMaster> projectRepository;

	@Override
	public ProjectMaster getInfoById(int id) {
		return projectRepository.findByProjectId(id);
	}

	@Override
	public List<ProjectMaster> getAllInfo() {
		return projectRepository.findAll();
	}

	@Override
	public boolean deleteInfo(int id) {
		projectRepository.delete((long) id);
		return true;
	}

	@Override
	public boolean updateInfo(ProjectMaster project) {
		projectRepository.save(project);
		return true;
	}

	@Override
	public boolean create(ProjectMaster project) {
		projectRepository.save(project);
		return true;
	}
}
