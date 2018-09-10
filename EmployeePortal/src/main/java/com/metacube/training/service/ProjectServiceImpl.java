package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.DAOInterface;
import com.metacube.training.model.ProjectMaster;

@Service
public class ProjectServiceImpl implements ServiceInterface<ProjectMaster> {

	@Autowired
	private DAOInterface<ProjectMaster> projectDAOInterface;

	@Override
	public ProjectMaster getInfoById(int id) {
		return projectDAOInterface.getInfoById(id);
	}

	@Override
	public List<ProjectMaster> getAllInfo() {
		return projectDAOInterface.getAllInfo();
	}

	@Override
	public boolean deleteInfo(int id) {
		return projectDAOInterface.deleteInfo(id);
	}

	@Override
	public boolean updateInfo(ProjectMaster project) {
		return projectDAOInterface.updateInfo(project);
	}

	@Override
	public boolean create(ProjectMaster project) {
		return projectDAOInterface.create(project);
	}

//	public boolean validateLogin(String email , String password) {
//		return projectDAOInterface.validateLogin(email,password);
//	}
}
