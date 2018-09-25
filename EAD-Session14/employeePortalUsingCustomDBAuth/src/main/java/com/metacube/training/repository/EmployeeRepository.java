package com.metacube.training.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.ProjectMaster;
import com.metacube.training.model.SkillsMaster;

@Repository
@Transactional
public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer> {

	/**
	 * Function to return the list of enabled employee
	 * 
	 * @return
	 */
	List<Employee> findByEnabled(boolean enabled);

	/**
	 * Function to get the employee details by employee code
	 * 
	 * @param code
	 * @return
	 */
	Employee findByCode(int code);

	/**
	 * Function to get the employee detail by id
	 * 
	 * @param email
	 * @return
	 */
	Employee findByEmailId(String email);

	/**
	 * Function to search the employee by name
	 * 
	 * @param firstName
	 * @return list of employees
	 */
	List<Employee> findByFirstNameContainingIgnoreCase(String firstName);

	/**
	 * Function to disable the employee
	 * 
	 * @param enabled
	 * @param id
	 * @return
	 */
	@Modifying
	@Query("UPDATE Employee SET enabled = :enabled WHERE code = :code")
	int setEnabledByCode(@Param("enabled") Boolean enabled,
			@Param("code") Integer id);

	/**
	 * Function to update the employee details by id
	 * 
	 * @param code
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param dob
	 * @param gender
	 * @param email
	 * @param contact
	 * @param skypeId
	 * @param profilePicture
	 * @return
	 */
	@Modifying
	@Query("UPDATE Employee SET firstName = :firstName, "
			+ "middleName = :middleName, " + "lastName = :lastName, "
			+ "dob = :dob, " + "gender = :gender, " + "email = :email, "
			+ "contact = :contact, " + "skypeId = :skypeId, "
			+ "profilePicture = :profilePicture " + "WHERE code = :code")
	int updateById(@Param("code") int code,
			@Param("firstName") String firstName,
			@Param("middleName") String middleName,
			@Param("lastName") String lastName, @Param("dob") Date dob,
			@Param("gender") String gender, @Param("email") String email,
			@Param("contact") String contact, @Param("skypeId") String skypeId,
			@Param("profilePicture") String profilePicture);

	/**
	 * Function to find the employees by skills
	 * 
	 * @param list
	 *            of skills
	 * @return
	 */
	List<Employee> findBySkills(List<SkillsMaster> skills);

	/**
	 * Function to find the employee by project
	 * 
	 * @param name
	 * @return
	 */
	List<Employee> findByProjects(List<ProjectMaster> projects);

	/**
	 * Function to find the employee by experience
	 * 
	 * @param totalExperience
	 * @return
	 */
	@Query("SELECT JD.employee FROM JobDetail JD "
			+ "WHERE JD.totalExperience = :totalExperience")
	List<Employee> findByExperience(
			@Param("totalExperience") int totalExperience);

}
