package com.telefonica.poccall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.codec.binary.Base64;

public class SimpleGetCall {

	public static void main(String[] args) {

		try {

			String userCredentials = "dev:dev!@#";
			String basicAuth = "Basic " + new String( Base64.encodeBase64String(userCredentials.getBytes()) );
			
			URL url = new URL("https://poccall.azurewebsites.net/accounts/11962252332/balances"); 
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty ("authorization", basicAuth);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false); 
			connection.setRequestMethod("GET"); 
			connection.setUseCaches (false);
			connection.connect();
			
			System.out.println(connection.getResponseCode()+" - "+connection.getResponseMessage());
			
			if(connection.getErrorStream() != null){
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(),"UTF-8"));
				String line = null;
				while((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}else{
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
				String line = null;
				while((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}
	        connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	
}
