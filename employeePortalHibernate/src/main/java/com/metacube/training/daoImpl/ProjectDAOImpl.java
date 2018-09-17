package com.metacube.training.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.daoInterface.ProjectDAO;
import com.metacube.training.model.ProjectMaster;

/**
 * Project Master dao class
 */
@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProjectMaster getInfoById(int id) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProjectMaster> criteria = builder
				.createQuery(ProjectMaster.class);
		Root<ProjectMaster> projectRoot = criteria.from(ProjectMaster.class);
		criteria.select(projectRoot);
		criteria.where(builder.equal(projectRoot.get("projectId"), id));

		ProjectMaster projectMaster = session.createQuery(criteria)
				.uniqueResult();

		return projectMaster;
	}

	@Override
	public List<ProjectMaster> getAllInfo() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProjectMaster> criteria = builder
				.createQuery(ProjectMaster.class);

		Root<ProjectMaster> projectRoot = criteria.from(ProjectMaster.class);
		criteria.select(projectRoot);
		List<ProjectMaster> projectMasterList = session.createQuery(criteria)
				.getResultList();
		session.close();
		return projectMasterList;
	}

	@Override
	public boolean create(ProjectMaster project) {
		if (sessionFactory.getCurrentSession().save(project) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateInfo(ProjectMaster project) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<ProjectMaster> criteria = builder
				.createCriteriaUpdate(ProjectMaster.class);

		Root<ProjectMaster> projectRoot = criteria.from(ProjectMaster.class);
		criteria.set(projectRoot.get("name"), project.getName()).where(
				builder.equal(projectRoot.get("projectId"),
						project.getProjectId()));
		criteria.set(projectRoot.get("description"), project.getDescription())
				.where(builder.equal(projectRoot.get("projectId"),
						project.getProjectId()));
		criteria.set(projectRoot.get("startDate"), project.getStartDate())
				.where(builder.equal(projectRoot.get("projectId"),
						project.getProjectId()));
		criteria.set(projectRoot.get("endDate"), project.getEndDate()).where(
				builder.equal(projectRoot.get("projectId"),
						project.getProjectId()));
		int updated = session.createQuery(criteria).executeUpdate();
		transaction.commit();

		session.close();
		return updated > 0;
	}

	@Override
	public boolean deleteInfo(int id) {
		return false;
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaUpdate<ProjectMaster> criteria = builder
//				.createCriteriaUpdate(ProjectMaster.class);
//		Root<ProjectMaster> projectRoot = criteria.from(ProjectMaster.class);
//		int updated = session.createQuery(criteria).executeUpdate();
//		transaction.commit();
//
//		session.close();
//		return updated > 0;
	}
}
