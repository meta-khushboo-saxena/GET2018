package com.metacube.training.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "job_details")
public class JobDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_detail_id")
	private int id;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_code")
	private Employee employee;

	@NotNull
	@Column(name = "date_of_joining")
	private Date dateOfJoining;
	@NotNull
	@Column(name = "total_experience")
	private int totalExperience;
	@NotNull
	@Column(name = "job_code")
	private int jobCode;
	@NotNull
	@Column(name = "reporting_manager")
	private int reportingManager;
	@NotNull
	@Column(name = "team_lead")
	private int teamLeader;
	@NotNull
	@Column(name = "current_project_id")
	private int projectId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public int getJobCode() {
		return jobCode;
	}

	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	public int getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(int reportingManager) {
		this.reportingManager = reportingManager;
	}

	public int getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(int teamLeader) {
		this.teamLeader = teamLeader;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Employee getEmployeeCode() {
		return employee;
	}

	public void setEmployeeCode(Employee employee) {
		this.employee = employee;
	}
}
