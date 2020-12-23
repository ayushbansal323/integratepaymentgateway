package com.roiim.restapi.pojo;

public class Card {

    public String lastDigits;

    public CardExpiry cardExpiry;

    public String cardBin;

    public String cardType;

    public String holderName;

	public String getLastDigits() {
		return lastDigits;
	}

	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}

	public CardExpiry getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(CardExpiry cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCardBin() {
		return cardBin;
	}

	public void setCardBin(String cardBin) {
		this.cardBin = cardBin;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
    
    
}
