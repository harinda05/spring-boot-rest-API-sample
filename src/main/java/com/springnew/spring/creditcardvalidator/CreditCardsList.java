package com.springnew.spring.creditcardvalidator;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CreditCardsList {
	
	public List<CreditCard> cards;

	public List<CreditCard> getCards() {
		return cards;
	}

	public void setCards(List<CreditCard> cards) {
		this.cards = cards;
	}
	
}
