package com.telefonica.mockapi.model;

import java.io.Serializable;

public class Bucket implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
	private int mode;
	private String bucketType;
	private RemainedAmount remainedAmount;
    private ValidFor validFor;
    private String status;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public String getBucketType() {
		return bucketType;
	}
	public void setBucketType(String bucketType) {
		this.bucketType = bucketType;
	}
	public RemainedAmount getRemainedAmount() {
		return remainedAmount;
	}
	public void setRemainedAmount(RemainedAmount remainedAmount) {
		this.remainedAmount = remainedAmount;
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
