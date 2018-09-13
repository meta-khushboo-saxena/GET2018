package com.metacube.training.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
* Class containing attributes of job title entity
*/
public class JobTitle {
	private int jobCode;
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9]{2,})$", message = "Enter valid job title")
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
