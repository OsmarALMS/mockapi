package com.telefonica.mockapi.model;

import com.microsoft.azure.storage.table.TableServiceEntity;

public class CountCalls extends TableServiceEntity{

	public CountCalls() {}
	
	public CountCalls(String service, String user, Long count) {
		this.partitionKey = service;
        this.rowKey = user;
        this.count = count;
	}
	
	private Long count = 0L;
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
}
