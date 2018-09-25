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
@Table(name = "employee_skills")
public class EmployeeSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_skill_id")
	private int id;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_code")
	private Employee employeeCode;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_code")
	private SkillsMaster skillCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Employee employeeCode) {
		this.employeeCode = employeeCode;
	}

	public SkillsMaster getSkillCode() {
		return skillCode;
	}

	public void setSkillCode(SkillsMaster skillCode) {
		this.skillCode = skillCode;
	}

}