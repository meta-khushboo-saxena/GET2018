package com.metacube.training.daoImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.daoInterface.SkillDAO;
import com.metacube.training.model.SkillsMaster;

/**
 * Skill dao class
 */
@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO {

	@Autowired
	private SessionFactory sessionFactory;

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
	public boolean create(SkillsMaster skillsMaster) {
		if (sessionFactory.getCurrentSession().save(skillsMaster) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateInfo(SkillsMaster t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
