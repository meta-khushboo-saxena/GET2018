package com.metacube.training.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.daoInterface.ProjectDAO;
import com.metacube.training.model.ProjectMaster;
import com.metacube.training.serviceInterface.ProjectServiceInterface;

/**
* Project Service class to provide interface between Controller and dao
*/
@Service
public class ProjectServiceImplement implements ProjectServiceInterface {

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public ProjectMaster getInfoById(int id) {
		return projectDAO.getInfoById(id);
	}

	@Override
	public List<ProjectMaster> getAllInfo() {
		return projectDAO.getAllInfo();
	}

	@Override
	public boolean deleteInfo(int id) {
		return projectDAO.deleteInfo(id);
	}

	@Override
	public boolean updateInfo(ProjectMaster project) {
		return projectDAO.updateInfo(project);
	}

	@Override
	public boolean create(ProjectMaster project) {
		return projectDAO.create(project);
	}
}
