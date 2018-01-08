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
import com.telefonica.mockapi.model.AccumulatedBalances;
import com.telefonica.mockapi.model.Bucket;
import com.telefonica.mockapi.model.MockTable;
import com.telefonica.mockapi.utils.DateUtils;
import com.telefonica.mockapi.utils.ObjectMapperUtils;
import com.telefonica.mockapi.utils.ServicosEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/subscriptions/{id}")
@Api(value="Subscriptions", description="endpoint para acessar as API's de Buckets e AccumulatedBalances")
public class SubscriptionsController {

	@Autowired
	private CountCallsDAO countCallsDAO;
	
	@Autowired
	private MockTableDAO mockTableDAO;
	
	@ApiOperation(value = "Mock API - Buckets", response = Bucket[].class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Retorno com sucesso!"),
        @ApiResponse(code = 401, message = "Não autorizado!")
	})
	@RequestMapping(value="/buckets", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> buckets(@PathVariable("id") String id){
		countCallsDAO.insertCountCall(ServicosEnum.buckets.name(), SecurityContextHolder.getContext().getAuthentication().getName());
		MockTable mockTable = mockTableDAO.buscaPorServicoTelefone(id, ServicosEnum.buckets.name());
		
		if(mockTable != null) {
			try {
				Bucket[] buckets = ObjectMapperUtils.mapper.readValue(mockTable.getJson(), Bucket[].class);
				String json = ObjectMapperUtils.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(buckets);
				return new ResponseEntity<>(json, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(new Object[0], HttpStatus.OK);
    }
	
	@ApiOperation(value = "Mock API - Accumulated Balances", response = AccumulatedBalances[].class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Retorno com sucesso!"),
        @ApiResponse(code = 401, message = "Não autorizado!")
	})
	@RequestMapping(value="/accumulatedBalances", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> accumulatedBalances(@PathVariable("id") String id){
		countCallsDAO.insertCountCall(ServicosEnum.accumulatedBalances.name(), SecurityContextHolder.getContext().getAuthentication().getName());
		MockTable mockTable = mockTableDAO.buscaPorServicoTelefone(id, ServicosEnum.accumulatedBalances.name());
		
		if(mockTable != null && mockTable.getJson() != null && !mockTable.getJson().equals("null")) {
			try {
				AccumulatedBalances[] accumulatedBalances = ObjectMapperUtils.mapper.readValue(mockTable.getJson(), AccumulatedBalances[].class);
				for(AccumulatedBalances accBalance : accumulatedBalances) {
					if(accBalance.getStatus().equals("active")) {
						accBalance.getValidFor().setStartDateTime(DateUtils.getCalcDateString(true, 1L)+"T20:29:40.000Z");
						accBalance.getValidFor().setEndDateTime(DateUtils.getCalcDateString(false, 29L)+"T23:59:59.000Z");
					}else if(accBalance.getStatus().equals("blocked")) {
						accBalance.getValidFor().setStartDateTime(DateUtils.getCalcDateString(true, 32L)+"T20:29:40.000Z");
						accBalance.getValidFor().setEndDateTime(DateUtils.getCalcDateString(true, 2L)+"T23:59:59.000Z");
					}
				}
				String json = ObjectMapperUtils.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accumulatedBalances);
				return new ResponseEntity<>(json, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(new Object[0], HttpStatus.OK);
    }

}