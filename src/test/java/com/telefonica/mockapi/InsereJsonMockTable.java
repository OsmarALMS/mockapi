package com.telefonica.mockapi;

import com.telefonica.mockapi.dao.MockTableDAO;
import com.telefonica.mockapi.utils.ServicosEnum;

public class InsereJsonMockTable {
	
	private static String TELEFONE = "1167742236";
	private static ServicosEnum SERVICE = ServicosEnum.balance;
	
	private static String JSON = 
			"[" + 
			"    {" + 
			"        \"type\": \"Plano de 4 GB\"," + 
			"        \"description\": \"PCT INTERNET CONTROLE 1GB 12M + Internet Mensal - Vivo Controle I 3GB\"," + 
			"        \"validFor\": {" + 
			"            \"startDateTime\": \"30\"," + 
			"            \"endDateTime\": \"30\"" + 
			"        }," + 
			"        \"remainedAmount\": {" + 
			"            \"amount\": 4294967296," + 
			"            \"consumed\": 0," + 
			"            \"maximum\": 4294967296," + 
			"            \"units\": \"B\"" + 
			"        }," + 
			"        \"inUse\": true," + 
			"        \"mainPackage\": true" + 
			"    }" + 
			"]" + 
			"";
	
	public static void main(String[] args) {
		MockTableDAO mockTableDAO = new MockTableDAO();
		mockTableDAO.insertMockTable(TELEFONE, SERVICE.name(), JSON);
	}
	
}
