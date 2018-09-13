package com.metacube.training.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Class containing the attributes of SkillMaster entity
 */
public class SkillsMaster {
	private int skillId;
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9]{2,})$", message = "Enter valid job title")
	private String skillName;

	public int getSkillId() {
		return skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

}
