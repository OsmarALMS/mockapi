package com.telefonica.mockapi.model;

import java.io.Serializable;

public class AccumulatedBalances implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private RemainedAmount totalBalance;
	private ValidFor validFor;
	private String status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RemainedAmount getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(RemainedAmount totalBalance) {
		this.totalBalance = totalBalance;
	}
	public ValidFor getValidFor() {
		return validFor;
	}
	public void setValidFor(ValidFor validFor) {
		this.validFor = validFor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
