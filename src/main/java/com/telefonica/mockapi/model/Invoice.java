package com.telefonica.mockapi.model;

public class Invoice {

	private Long msisdn;
	private String clientPlatformType;
	private String country;
	private String creationDate;
	private String dueDate;
	private String status;
	private String monthRef;
	private DocumentLinks documentLinks;
	private RemainedAmount totalAmount;
	private AdjustedInvoice adjustedInvoice;
	
	public Long getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(Long msisdn) {
		this.msisdn = msisdn;
	}
	public String getClientPlatformType() {
		return clientPlatformType;
	}
	public void setClientPlatformType(String clientPlatformType) {
		this.clientPlatformType = clientPlatformType;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMonthRef() {
		return monthRef;
	}
	public void setMonthRef(String monthRef) {
		this.monthRef = monthRef;
	}
	public DocumentLinks getDocumentLinks() {
		return documentLinks;
	}
	public void setDocumentLinks(DocumentLinks documentLinks) {
		this.documentLinks = documentLinks;
	}
	public RemainedAmount getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(RemainedAmount totalAmount) {
		this.totalAmount = totalAmount;
	}
	public AdjustedInvoice getAdjustedInvoice() {
		return adjustedInvoice;
	}
	public void setAdjustedInvoice(AdjustedInvoice adjustedInvoice) {
		this.adjustedInvoice = adjustedInvoice;
	}
}
