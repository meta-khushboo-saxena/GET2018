package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Class containing attributes of job title entity
 */
@Entity
@Table(name = "job_title")
public class JobTitle {
	@Id
	@Column(name = "job_code")
	private int jobCode;
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9]{2,})$", message = "Enter valid job title")
	@Column(name = "job_title")
	private String jobTitle;

	public int getJobCode() {
		return jobCode;
	}

	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}
