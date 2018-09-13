package com.metacube.training.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Class containing attributes of ProjectMaster entity
 */
public class ProjectMaster {
	private int projectId;
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9]{2,})$", message = "Enter valid project name")
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private String projectLogo;

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getProjectId() {
		return projectId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProjectLogo() {
		return projectLogo;
	}

	public void setProjectLogo(String projectLogo) {
		this.projectLogo = projectLogo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
