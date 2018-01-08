package com.telefonica.mockapi.model;

import com.microsoft.azure.storage.table.TableServiceEntity;

public class MockTable extends TableServiceEntity{

	public MockTable() {}
	
	public MockTable(String telefone, String service, String json) {
		this.partitionKey = telefone;
        this.rowKey = service;
        this.json = json;
	}
	
	private String json;
	
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
}
