package ar.com.avantrip.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RulesResquest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameRule;
	
	private String descriptionRule;
	
	private int priorityRule;
	
	private String conditionRule;
	
	private String actionRule;
	
	private boolean isActive;
	
	public RulesResquest() {
	}

	public RulesResquest(String nameRule, String descriptionRule, int priorityRule, String conditionRule,
			String actionRule, boolean isActive) {
		this.nameRule = nameRule;
		this.descriptionRule = descriptionRule;
		this.priorityRule = priorityRule;
		this.conditionRule = conditionRule;
		this.actionRule = actionRule;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameRule() {
		return nameRule;
	}

	public void setNameRule(String nameRule) {
		this.nameRule = nameRule;
	}

	public String getDescriptionRule() {
		return descriptionRule;
	}

	public void setDescriptionRule(String descriptionRule) {
		this.descriptionRule = descriptionRule;
	}

	public int getPriorityRule() {
		return priorityRule;
	}

	public void setPriorityRule(int priorityRule) {
		this.priorityRule = priorityRule;
	}

	public String getConditionRule() {
		return conditionRule;
	}

	public void setConditionRule(String conditionRule) {
		this.conditionRule = conditionRule;
	}

	public String getActionRule() {
		return actionRule;
	}

	public void setActionRule(String actionRule) {
		this.actionRule = actionRule;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
