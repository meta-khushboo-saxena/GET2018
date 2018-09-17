package com.metacube.training.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.daoInterface.EmployeeDAO;
import com.metacube.training.model.Employee;

/**
 * Employee dao class
 */
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Employee getInfoById(int id) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.equal(employeeRoot.get("code"), id));

		Employee employee = session.createQuery(criteria).uniqueResult();

		return employee;
	}

	@Override
	public List<Employee> getAllInfo() {

		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.equal(employeeRoot.get("enabled"), "true"));
		List<Employee> employeeList = session.createQuery(criteria)
				.getResultList();
		session.close();
		return employeeList;

	}

	@Override
	public boolean create(Employee employee) {
		if (sessionFactory.getCurrentSession().save(employee) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateInfo(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteria = builder
				.createCriteriaUpdate(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.set(employeeRoot.get("firstName"), employee.getFirstName())
				.where(builder.equal(employeeRoot.get("code"),
						employee.getCode()));
		criteria.set(employeeRoot.get("middleName"), employee.getMiddleName())
				.where(builder.equal(employeeRoot.get("code"),
						employee.getCode()));
		criteria.set(employeeRoot.get("lastName"), employee.getLastName())
				.where(builder.equal(employeeRoot.get("code"),
						employee.getCode()));
		criteria.set(employeeRoot.get("dob"), employee.getDob()).where(
				builder.equal(employeeRoot.get("code"), employee.getCode()));
		criteria.set(employeeRoot.get("gender"), employee.getGender()).where(
				builder.equal(employeeRoot.get("code"), employee.getCode()));
		criteria.set(employeeRoot.get("contact"), employee.getContact()).where(
				builder.equal(employeeRoot.get("code"), employee.getCode()));
		criteria.set(employeeRoot.get("emailId"), employee.getEmailId()).where(
				builder.equal(employeeRoot.get("code"), employee.getCode()));
		criteria.set(employeeRoot.get("skypeId"), employee.getSkypeId()).where(
				builder.equal(employeeRoot.get("code"), employee.getCode()));
		criteria.set(employeeRoot.get("profilePicture"),
				employee.getProfilePicture()).where(
				builder.equal(employeeRoot.get("code"), employee.getCode()));

		int updated = session.createQuery(criteria).executeUpdate();
		transaction.commit();

		session.close();
		return updated > 0;
	}

	@Override
	public boolean deleteInfo(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteria = builder
				.createCriteriaUpdate(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.set(employeeRoot.get("enabled"), "false").where(
				builder.equal(employeeRoot.get("code"), id));

		int updated = session.createQuery(criteria).executeUpdate();
		transaction.commit();

		session.close();
		return updated > 0;
	}

	@Override
	public Employee getInfoByEmail(String email) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.equal(employeeRoot.get("emailId"), email));

		Employee employee = session.createQuery(criteria).uniqueResult();

		return employee;
	}

	@Override
	public List<Employee> getInfoByName(String name) {

		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.like(employeeRoot.get("firstName"), "%" + name
				+ "%"));
		List<Employee> employeeList = session.createQuery(criteria)
				.getResultList();

		session.close();
		return employeeList;
	}

	@Override
	public List<Employee> getInfoByProject(String project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getInfoBySkills(String skills) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getInfoByExperience(String experience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean resetPassword(String email, String oldPassword,
			String newPassword) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteria = builder
				.createCriteriaUpdate(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.set(employeeRoot.get("password"), newPassword).where(
				builder.equal(employeeRoot.get("password"), oldPassword));

		int updated = session.createQuery(criteria).executeUpdate();
		transaction.commit();

		session.close();
		return updated > 0;
	}

	@Override
	public boolean forgotPassword(String email, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee validateLogin(String email, String password) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		criteria.add(Restrictions.eq("emailId", email));
		criteria.add(Restrictions.eq("password", password));
		return (Employee) criteria.uniqueResult();
	}
}
