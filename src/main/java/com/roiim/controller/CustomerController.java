package com.roiim.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.roiim.dao.CustomerDAO;
import com.roiim.pojo.Customer;
import com.roiim.pojo.EmailWrapper;
import com.roiim.restapi.CustomerAPI;
import com.roiim.restapi.pojo.CustomerTokenResponse;
import com.roiim.util.Util;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDAO mCustomerDAO;
	
	@Autowired
	private CustomerAPI mCustomerAPI;
	
	@RequestMapping(path="singleusecustomertoken", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE
			, produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView singleUseCustomerToken(@RequestBody EmailWrapper pEmailWrapper) {
		ModelAndView lResponse= new ModelAndView();
		if(pEmailWrapper==null || pEmailWrapper.getEmail()==null || pEmailWrapper.getEmail().equals(""))
		{
			lResponse = Util.getFailedResponse();
			return lResponse;
		}
		String lstrCustomerID = mCustomerDAO.getCustomerIDFromEmail(pEmailWrapper.getEmail());
		Customer lCustomer  = new Customer();;
		if(lstrCustomerID == null) 
		{
			lstrCustomerID = mCustomerAPI.getCustomerID(pEmailWrapper.getEmail());
			lCustomer.setCustomerId(lstrCustomerID);
			lCustomer.setEmail(pEmailWrapper.getEmail());
			int liResponse = mCustomerDAO.insertCustomer(lCustomer);
			if(liResponse == -1)
			{
				lResponse = Util.getFailedResponse();
				return lResponse;
			}
		}
		else
		{
			lCustomer.setEmail(pEmailWrapper.getEmail());
			lCustomer.setCustomerId(lstrCustomerID);
		}
		lResponse.setViewName("forward:singleusecustomertoken/"+lstrCustomerID);
		return lResponse;
	}

	
	@RequestMapping(path="singleusecustomertoken/{customerId}", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmp(@PathVariable("customerId") String customerId) {
		CustomerTokenResponse lCustomerToken = mCustomerAPI.getSingleUseCustomerTokenFromCustomerId(customerId);
		if(lCustomerToken!=null){
			System.out.println(lCustomerToken);
			return ResponseEntity.ok(lCustomerToken);
		} else {
			return ResponseEntity.ok("{\"status\":\"Not found entry\"}");
	
		}
	}
	
}


