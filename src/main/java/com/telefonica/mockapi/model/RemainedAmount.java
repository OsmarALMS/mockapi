package com.telefonica.mockapi.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RemainedAmount implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal amount;
	private BigDecimal consumed;
	private BigDecimal maximum;
	private String units;

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getMaximum() {
		return maximum;
	}
	public void setMaximum(BigDecimal maximum) {
		this.maximum = maximum;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public BigDecimal getConsumed() {
		return consumed;
	}
	public void setConsumed(BigDecimal consumed) {
		this.consumed = consumed;
	}

}
