package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.SkillsMaster;

public interface SkillsRepository <P> extends JpaRepository<SkillsMaster, Long> {
	SkillsMaster findBySkillId(int id);
	
	List<SkillsMaster> findBySkillName(String name);
}
