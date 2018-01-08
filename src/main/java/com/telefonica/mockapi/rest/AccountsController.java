package com.telefonica.mockapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.mockapi.dao.CountCallsDAO;
import com.telefonica.mockapi.dao.MockTableDAO;
import com.telefonica.mockapi.model.Balance;
import com.telefonica.mockapi.model.Invoice;
import com.telefonica.mockapi.model.MockTable;
import com.telefonica.mockapi.model.Product;
import com.telefonica.mockapi.utils.DateUtils;
import com.telefonica.mockapi.utils.ObjectMapperUtils;
import com.telefonica.mockapi.utils.ServicosEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/accounts/{id}")
@Api(value="Accounts", description="endpoint para acessar as API's de Balances, Products e Invoices")
public class AccountsController {

	@Autowired
	private CountCallsDAO countCallsDAO;
	
	@Autowired
	private MockTableDAO mockTableDAO;
	
	@ApiOperation(value = "Mock API - Balances", response = Balance[].class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Retorno com sucesso!"),
        @ApiResponse(code = 401, message = "Não autorizado!")
	})
	@RequestMapping(value="/balances", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getGreetingSimple(@PathVariable("id") String id){
		countCallsDAO.insertCountCall(ServicosEnum.balance.name(), SecurityContextHolder.getContext().getAuthentication().getName());
		MockTable mockTable = mockTableDAO.buscaPorServicoTelefone(id, ServicosEnum.balance.name());
		
		if(mockTable != null && mockTable.getJson() != null && !mockTable.getJson().equals("null")) {
			try {
				Balance[] balances = ObjectMapperUtils.mapper.readValue(mockTable.getJson(), Balance[].class);
				for(Balance balance : balances) {
					if(balance.getValidFor().getStartDateTime().equals("7") && balance.getValidFor().getEndDateTime().equals("7")) {
						balance.getValidFor().setStartDateTime(DateUtils.getCalcDateString(true, 0L)+"T00:00:00.000Z");
						balance.getValidFor().setEndDateTime(DateUtils.getCalcDateString(false, 7L)+"T23:59:59.000Z");
					}else if(balance.getValidFor().getStartDateTime().equals("30") && balance.getValidFor().getEndDateTime().equals("30")){
						balance.getValidFor().setStartDateTime(DateUtils.getCalcDateString(true, 1L)+"T00:00:00.000Z");
						balance.getValidFor().setEndDateTime(DateUtils.getCalcDateString(false, 29L)+"T23:59:59.000Z");
					}
				}
				String json = ObjectMapperUtils.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(balances);
				return new ResponseEntity<>(json, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return new ResponseEntity<>(new Object[0], HttpStatus.OK);
	}
	
	@ApiOperation(value = "Mock API - Products", response = Product[].class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Retorno com sucesso!"),
        @ApiResponse(code = 401, message = "Não autorizado!")
	})
	@RequestMapping(value="/products", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> productList(@PathVariable("id") String id){
		countCallsDAO.insertCountCall(ServicosEnum.products.name(), SecurityContextHolder.getContext().getAuthentication().getName());
		MockTable mockTable = mockTableDAO.buscaPorServicoTelefone(id, ServicosEnum.products.name());
		
		if(mockTable != null) {
			try {
				Product[] products = ObjectMapperUtils.mapper.readValue(mockTable.getJson(), Product[].class);
				String json = ObjectMapperUtils.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
				return new ResponseEntity<>(json, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(new Object[0], HttpStatus.OK);
    }
	
	@ApiOperation(value = "Mock API - Products", response = Invoice[].class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Retorno com sucesso!"),
        @ApiResponse(code = 401, message = "Não autorizado!")
	})
	@RequestMapping(value="/invoices", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> invoiceList(@PathVariable("id") String id){
		countCallsDAO.insertCountCall(ServicosEnum.invoices.name(), SecurityContextHolder.getContext().getAuthentication().getName());
		MockTable mockTable = mockTableDAO.buscaPorServicoTelefone(id, ServicosEnum.invoices.name());
		
		if(mockTable != null) {
			try {
				Invoice[] invoices = ObjectMapperUtils.mapper.readValue(mockTable.getJson(), Invoice[].class);
				String json = ObjectMapperUtils.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(invoices);
				return new ResponseEntity<>(json, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(new Object[0], HttpStatus.OK);
    }

}