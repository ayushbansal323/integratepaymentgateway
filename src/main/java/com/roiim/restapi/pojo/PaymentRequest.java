package com.roiim.restapi.pojo;

import com.roiim.pojo.Payment;

public class PaymentRequest {

    private String merchantRefNum;

    private Integer amount;

    private String currencyCode;

    private boolean dupCheck;

    private boolean settleWithAuth;

    private String paymentHandleToken;

    private String customerIp;

    private String description;

    public PaymentRequest(Payment pPayment) {
		this.merchantRefNum = pPayment.getMerchantRefNum();
		this.amount = pPayment.getAmount();
		this.currencyCode = pPayment.getCurrencyCode();
		this.paymentHandleToken = pPayment.getPaymentHandleToken();
		this.dupCheck = true;
		this.settleWithAuth = false;
	}

	public String getMerchantRefNum() {
        return merchantRefNum;
    }

    public void setMerchantRefNum(String merchantRefNum) {
        this.merchantRefNum = merchantRefNum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public boolean isDupCheck() {
        return dupCheck;
    }

    public void setDupCheck(boolean dupCheck) {
        this.dupCheck = dupCheck;
    }

    public boolean isSettleWithAuth() {
        return settleWithAuth;
    }

    public void setSettleWithAuth(boolean settleWithAuth) {
        this.settleWithAuth = settleWithAuth;
    }

    public String getPaymentHandleToken() {
        return paymentHandleToken;
    }

    public void setPaymentHandleToken(String paymentHandleToken) {
        this.paymentHandleToken = paymentHandleToken;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "merchantRefNum='" + merchantRefNum + '\'' +
                ", amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                ", dupCheck=" + dupCheck +
                ", settleWithAuth=" + settleWithAuth +
                ", paymentHandleToken='" + paymentHandleToken + '\'' +
                ", customerIp='" + customerIp + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
