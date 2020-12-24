package com.roiim.restapi;

import java.io.IOException;
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
import com.roiim.pojo.Payment;
import com.roiim.restapi.pojo.PaymentRequest;
import com.roiim.restapi.pojo.PaymentResponse;
import com.roiim.util.PaymentConstant;

public class PaymentAPI {
	public PaymentResponse makePayment( Payment pPayment ){

		PaymentRequest lPaymentRequest = new PaymentRequest(pPayment);
        System.out.println( "In make payment" );

        // create an url for the payemnt api
        String mstrUrl = PaymentConstant.BASE_PAYSAFE_URL + PaymentConstant.SLASH + PaymentConstant.PAYMENTS;

        // create new http header and set content type to application/json
        HttpHeaders lHttpHeaders = new HttpHeaders();
        lHttpHeaders.setContentType(MediaType.APPLICATION_JSON);
        lHttpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // set basic authorization with api key and its value
        lHttpHeaders.setBasicAuth( PaymentConstant.API_KEY_ID, PaymentConstant.API_KEY_PASSWORD );
        Random lRandom = new Random(System.currentTimeMillis());
        lPaymentRequest.setCustomerIp( "10.10.12.64" );
        lPaymentRequest.setMerchantRefNum( String.valueOf( lRandom.nextInt() ) );

        // convert request object into json object
        ObjectMapper lObjectMapper = new ObjectMapper();
        String lstrJsonString = null;
        try {

        	lstrJsonString = lObjectMapper.writeValueAsString( lPaymentRequest );
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // build the request
        HttpEntity< String > lHttpEntity = new HttpEntity<String>( lstrJsonString, lHttpHeaders );

        // send POST request
        RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PaymentResponse> lResponseEntity = restTemplate.postForEntity( mstrUrl, lHttpEntity, PaymentResponse.class );

        if( lResponseEntity.getStatusCode() != HttpStatus.CREATED ){

            // throw an exception
        }

        return lResponseEntity.getBody();
    }

}
