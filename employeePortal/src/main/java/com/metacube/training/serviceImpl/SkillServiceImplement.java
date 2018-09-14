package com.metacube.training.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.daoInterface.SkillDAO;
import com.metacube.training.model.SkillsMaster;
import com.metacube.training.serviceInterface.SkillServiceInterface;

/**
 * Skill Service class to provide inteface between the controller and the dao
 */
@Service
public class SkillServiceImplement implements SkillServiceInterface{

	@Autowired
	private SkillDAO skillDAO;

	@Override
	public SkillsMaster getInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillsMaster> getAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateInfo(SkillsMaster object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(SkillsMaster skillsMaster) {
		return skillDAO.create(skillsMaster);
	}

}
