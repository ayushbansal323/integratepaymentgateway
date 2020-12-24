package com.roiim.restapi;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roiim.restapi.pojo.CustomerRequest;
import com.roiim.restapi.pojo.CustomerResponse;
import com.roiim.restapi.pojo.CustomerTokenRequest;
import com.roiim.restapi.pojo.CustomerTokenResponse;
import com.roiim.restapi.pojo.Date;
import com.roiim.util.PaymentConstant;

public class CustomerAPI {

	
	public String getCustomerID(String pstrEmail)
	{
		String lstrUrl = PaymentConstant.BASE_PAYSAFE_URL + PaymentConstant.SLASH + PaymentConstant.CUSTOMERS;

		HttpHeaders lHttpHeaders = getHttpHeaders();
        // create a new map for the body of the request and put all the values received from the user in the map
        CustomerRequest lCustomerRequest = new CustomerRequest();
        lCustomerRequest.setEmail( pstrEmail );
        // convert request object in to json object
        ObjectMapper lObjectMapper = new ObjectMapper();
        String lstrJsonString = null;
        try {
        	lstrJsonString = lObjectMapper.writeValueAsString(lCustomerRequest);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( lstrJsonString );

        // build the request
        HttpEntity< String > lHttpEntity = new HttpEntity< String >( lstrJsonString, lHttpHeaders );
        RestTemplate lRestTemplate = new RestTemplate();
        // send POST request
        ResponseEntity< CustomerResponse > lResponseEntity = lRestTemplate.postForEntity( lstrUrl, lHttpEntity, CustomerResponse.class );

        // check if user is successfully created
        if( lResponseEntity.getStatusCode() == HttpStatus.CREATED ){
            // get the response
            CustomerResponse lCustomerResponse = lResponseEntity.getBody();
            // create new record for the customer in local database and set it's attributes values
            return lCustomerResponse.getId();
        }
        else {
            System.out.println( "failed user creation" );
            return null;
        }

	}

	public CustomerTokenResponse getSingleUseCustomerTokenFromCustomerId(String mstrCustomerId) {
		String mstrURL = PaymentConstant.BASE_PAYSAFE_URL + PaymentConstant.SLASH + 
						 PaymentConstant.CUSTOMERS + PaymentConstant.SLASH + 
						 mstrCustomerId + PaymentConstant.SLASH + 
						 PaymentConstant.SINGLE_USE_COSTOMER_TOKEN ;

		HttpHeaders lHttpHeaders = getHttpHeaders();
        // create request object
        CustomerTokenRequest lCustomerTokenRequest = new CustomerTokenRequest();
        Random lRandom = new Random(System.currentTimeMillis());
        lCustomerTokenRequest.setMerchantRefNum( String.valueOf( lRandom.nextInt() ) );
        lCustomerTokenRequest.setPaymentTypes( Arrays.asList( PaymentConstant.CARD ) );

        // convert request object in to json object
        ObjectMapper lObjectMapper = new ObjectMapper();
        String lstrJsonString = null;
        try {

        	lstrJsonString = lObjectMapper.writeValueAsString( lCustomerTokenRequest );
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // build the request
        HttpEntity< String > lHttpEntity = new HttpEntity<String>( lstrJsonString, lHttpHeaders );

        RestTemplate lRestTemplate = new RestTemplate();
		// send POST request
        ResponseEntity< CustomerTokenResponse > lResponseEntity = lRestTemplate.postForEntity( mstrURL, lHttpEntity, CustomerTokenResponse.class );

        if( lResponseEntity.getStatusCode().equals( HttpStatus.CREATED ) ) {
            CustomerTokenResponse lCustomerTokenResponse = lResponseEntity.getBody();
            lCustomerTokenResponse.setMerchantRefNum(lCustomerTokenRequest.getMerchantRefNum());
            System.out.println(lResponseEntity.getBody());
            return lResponseEntity.getBody();
        }
        return null;
	}
	
	
	private HttpHeaders getHttpHeaders()
	{
		// create new http header and set content type to application/json
        HttpHeaders lHttpHeaders = new HttpHeaders();
        lHttpHeaders.setContentType(MediaType.APPLICATION_JSON);
        lHttpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set basic authorization with api key and its value
        lHttpHeaders.setBasicAuth( PaymentConstant.API_KEY_ID, PaymentConstant.API_KEY_PASSWORD );
        return lHttpHeaders;
	}
}
