package com.metacube.training.serviceInterface;

import java.util.List;

import com.metacube.training.model.ProjectMaster;

public interface ProjectServiceInterface {

	ProjectMaster getInfoById(int id);

	List<ProjectMaster> getAllInfo();

	boolean deleteInfo(int id);

	boolean updateInfo(ProjectMaster projectMaster);

	boolean create(ProjectMaster projectMaster);

}
