package com.roiim.restapi.pojo;


public class PaymentResponse {

    public String id;

    public Integer amount;

    public String merchantRefNum;

    public Boolean settleWithAuth;

    public String paymentHandleToken;

    public String txnTime;

    public String customerIp;

    public Boolean dupCheck;

    public String description;

    public String currencyCode;

    public String paymentType;

    public String status;

    public Integer availableToSettle;

    public GatewayResponse gatewayResponse;

    public String customerId;

    public String merchantCustomerId;
}
