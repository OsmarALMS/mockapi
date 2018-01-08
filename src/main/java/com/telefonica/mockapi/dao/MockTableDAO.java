package com.telefonica.mockapi.dao;

import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;
import com.telefonica.mockapi.model.MockTable;
import com.telefonica.mockapi.utils.AzureUtils;

@Component
public class MockTableDAO {

	public MockTable buscaPorServicoTelefone(String telefone, String service) {
		try {
		    CloudStorageAccount storageAccount = CloudStorageAccount.parse(AzureUtils.storageConnectionString);
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();
		    CloudTable cloudTable = tableClient.getTableReference("mocktable");
		    
		    TableOperation retrieve = TableOperation.retrieve(telefone, service, MockTable.class);
		    return cloudTable.execute(retrieve).getResultAsType();
		}
		catch (Exception e){
		    e.printStackTrace();
		}
		return null;
	}
	
	public void insertMockTable(String telefone, String service, String json) {
		try {
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(AzureUtils.storageConnectionString);
		    CloudTableClient tableClient = storageAccount.createCloudTableClient();
		    CloudTable cloudTable = tableClient.getTableReference("mocktable");
		    TableOperation insert = TableOperation.insertOrReplace(new MockTable(telefone, service, json));
		    cloudTable.execute(insert);
		}
		catch (Exception e){
		    e.printStackTrace();
		}
	}
	
}
