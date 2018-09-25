package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Class containing the attributes of SkillMaster entity
 */
@Entity
@Table(name = "skill_master")
public class SkillsMaster {
	@Id
	@Column(name = "skill_id")
	private int skillId;
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9]{2,})$", message = "Enter valid job title")
	@Column(name = "skill_name")
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
