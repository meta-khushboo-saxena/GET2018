package com.metacube.training.model;

/**
* Class containing the attributes of SkillMaster entity
*/
public class SkillsMaster {
	private int skillId;
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
