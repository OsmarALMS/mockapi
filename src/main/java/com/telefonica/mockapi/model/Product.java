package com.telefonica.mockapi.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String status;
	private List<Characteristic> characteristic;
	private String startDate;
	private String terminationDate;
	private List<ProductPrice> productPrice;
	private String idFamily;
	private String nameFamily;
	private String productType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Characteristic> getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(List<Characteristic> characteristic) {
		this.characteristic = characteristic;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}
	public List<ProductPrice> getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(List<ProductPrice> productPrice) {
		this.productPrice = productPrice;
	}
	public String getIdFamily() {
		return idFamily;
	}
	public void setIdFamily(String idFamily) {
		this.idFamily = idFamily;
	}
	public String getNameFamily() {
		return nameFamily;
	}
	public void setNameFamily(String nameFamily) {
		this.nameFamily = nameFamily;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
}
