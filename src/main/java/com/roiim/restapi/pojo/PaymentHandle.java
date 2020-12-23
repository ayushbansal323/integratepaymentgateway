package com.roiim.restapi.pojo;

public class PaymentHandle {

    public String id;

    public String status;

    public String usage;

    public String paymentType;

    public String paymentHandleToken;

    public String billingDetailsId;

    public Card card;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentHandleToken() {
		return paymentHandleToken;
	}

	public void setPaymentHandleToken(String paymentHandleToken) {
		this.paymentHandleToken = paymentHandleToken;
	}

	public String getBillingDetailsId() {
		return billingDetailsId;
	}

	public void setBillingDetailsId(String billingDetailsId) {
		this.billingDetailsId = billingDetailsId;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
    
    
}
