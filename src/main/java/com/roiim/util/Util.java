package com.roiim.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.roiim.restapi.CustomerAPI;

public class Util {
	
	
	public static String createCustomer(String pstrEmail)
	{
		CustomerAPI lCustomerAPI = new CustomerAPI();
		String lmstCustomerID = lCustomerAPI.getCustomerID(pstrEmail);
		
		return lmstCustomerID;
		
	}
	
	public static ModelAndView getFailedResponse()
	{
		ModelAndView lResponse= new ModelAndView();

		MappingJackson2JsonView view = new MappingJackson2JsonView();
		Map<String, String> data = new HashMap<String,String>();
	    data.put("status", "FAILED");
	    view.setAttributesMap(data);
		lResponse.setView(view);
		return lResponse;
	
	}
}
