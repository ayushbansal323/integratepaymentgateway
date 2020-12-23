package com.roiim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.roiim.pojo.EmailWrapper;
import com.roiim.pojo.Payment;
import com.roiim.restapi.PaymentAPI;
import com.roiim.restapi.pojo.PaymentResponse;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentAPI mPaymentAPI;
	
    
    @RequestMapping(path="makepayment", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE
			, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity singleUseCustomerToken(@RequestBody Payment pPayment) {
        PaymentResponse lPaymentResponse = mPaymentAPI.makePayment(pPayment);
        if(lPaymentResponse!=null){
			System.out.println(lPaymentResponse);
			return ResponseEntity.ok(lPaymentResponse);
		} else {
			return ResponseEntity.ok("{\"status\":\"FAILED\"}");
	
		}
    }
}
