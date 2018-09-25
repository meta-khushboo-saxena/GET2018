package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.model.ProjectMaster;

public interface ProjectRepository<P> extends
		JpaRepository<ProjectMaster, Long> {
	ProjectMaster findByProjectId(int id);

	List<ProjectMaster> findByName(String name);
}
