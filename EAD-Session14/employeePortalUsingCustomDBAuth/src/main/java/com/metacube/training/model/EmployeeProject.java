package com.metacube.training.model;

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
@Table(name = "employee_project")
public class EmployeeProject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_project_id")
	private int id;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_code")
	private Employee employee;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private ProjectMaster project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployeeCode() {
		return employee;
	}

	public void setEmployeeCode(Employee employee) {
		this.employee = employee;
	}

	public ProjectMaster getProjectCode() {
		return project;
	}

	public void setProjectCode(ProjectMaster project) {
		this.project = project;
	}
	
}