package com.telefonica.mockapi.model;

import java.io.Serializable;

public class Balance implements Serializable{
	private static final long serialVersionUID = 1L;

	private String type;
	private String description;
    private ValidFor validFor;
    private RemainedAmount remainedAmount;
    private Boolean inUse;
    private Boolean mainPackage;

    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public ValidFor getValidFor() {
		return validFor;
	}
	public void setValidFor(ValidFor validFor) {
		this.validFor = validFor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getInUse() {
		return inUse;
	}
	public void setInUse(Boolean inUse) {
		this.inUse = inUse;
	}
	public Boolean getMainPackage() {
		return mainPackage;
	}
	public void setMainPackage(Boolean mainPackage) {
		this.mainPackage = mainPackage;
	}
	public RemainedAmount getRemainedAmount() {
		return remainedAmount;
	}
	public void setRemainedAmount(RemainedAmount remainedAmount) {
		this.remainedAmount = remainedAmount;
	}

}
