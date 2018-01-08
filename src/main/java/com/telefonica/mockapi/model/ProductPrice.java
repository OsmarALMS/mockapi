package com.telefonica.mockapi.model;

import java.io.Serializable;

public class ProductPrice implements Serializable{
	private static final long serialVersionUID = 1L;

	private String priceType;
    private Price price;

    public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
}
