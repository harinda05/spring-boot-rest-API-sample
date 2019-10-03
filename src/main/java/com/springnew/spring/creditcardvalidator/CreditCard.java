package com.springnew.spring.creditcardvalidator;

import org.springframework.stereotype.Component;

@Component
public class CreditCard {
	
	private String cardNo;
	private String expirydate;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	
}
