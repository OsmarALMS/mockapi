package com.telefonica.mockapi.dao;

import org.springframework.stereotype.Component;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;
import com.telefonica.mockapi.model.CountCalls;
import com.telefonica.mockapi.utils.AzureUtils;

@Component
public class CountCallsDAO {

	public void insertCountCall(String service, String user) {
		try {
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(AzureUtils.storageConnectionString);
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();
		    CloudTable cloudTable = tableClient.getTableReference("countcalls");
		    TableOperation retrieveCount = TableOperation.retrieve(service, user, CountCalls.class);
		    CountCalls countCallObject = cloudTable.execute(retrieveCount).getResultAsType();

		    if (countCallObject != null){
		        countCallObject.setCount(countCallObject.getCount()+1);
		    }else {
		    	countCallObject = new CountCalls(service, user, 1L);
		    }
		    
		    TableOperation insert = TableOperation.insertOrReplace(countCallObject);
		    cloudTable.execute(insert);
		}
		catch (Exception e){
		    e.printStackTrace();
		}
	}
	
}
