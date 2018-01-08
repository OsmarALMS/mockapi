package com.telefonica.mockapi.model;

import java.math.BigDecimal;

public class AdjustedInvoice {

	private String dueDateAdjusted;
	private String invoiceStatusAdjusted;
	private BigDecimal amountAdjustmentValue;
	private BigDecimal totalAmountAdjusted;
	private DocumentLinks documentLinks;
	
	public String getDueDateAdjusted() {
		return dueDateAdjusted;
	}
	public void setDueDateAdjusted(String dueDateAdjusted) {
		this.dueDateAdjusted = dueDateAdjusted;
	}
	public String getInvoiceStatusAdjusted() {
		return invoiceStatusAdjusted;
	}
	public void setInvoiceStatusAdjusted(String invoiceStatusAdjusted) {
		this.invoiceStatusAdjusted = invoiceStatusAdjusted;
	}
	public BigDecimal getAmountAdjustmentValue() {
		return amountAdjustmentValue;
	}
	public void setAmountAdjustmentValue(BigDecimal amountAdjustmentValue) {
		this.amountAdjustmentValue = amountAdjustmentValue;
	}
	public BigDecimal getTotalAmountAdjusted() {
		return totalAmountAdjusted;
	}
	public void setTotalAmountAdjusted(BigDecimal totalAmountAdjusted) {
		this.totalAmountAdjusted = totalAmountAdjusted;
	}
	public DocumentLinks getDocumentLinks() {
		return documentLinks;
	}
	public void setDocumentLinks(DocumentLinks documentLinks) {
		this.documentLinks = documentLinks;
	}
}
