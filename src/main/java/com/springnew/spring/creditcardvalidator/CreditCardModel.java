package com.springnew.spring.creditcardvalidator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.springnew.spring.flight.Flight;
import com.springnew.spring.flight.Flights;

@Component
public class CreditCardModel {
	@Autowired
	private CardValidator cvalidator;
	
	public List<String> validateCard(String cardsList) {
		
		List<String> blacklistCardNos = new ArrayList();
		Gson g = new Gson();
		CreditCardsList p = g.fromJson(cardsList, CreditCardsList.class);
		
		for(int i=0; i<p.getCards().size();i++) {
			
			CreditCard card = p.getCards().get(i);
			
			String cardno = card.getCardNo();
			String expdate = card.getExpirydate();
			
			boolean valid = cvalidator.ValidateCard(cardno, expdate);
			
			if(!valid) {
				blacklistCardNos.add(cardno);
			}
			
		}
		return blacklistCardNos;
	}
	
	
}
