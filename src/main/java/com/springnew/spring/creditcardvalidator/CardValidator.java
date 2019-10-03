package com.springnew.spring.creditcardvalidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CardValidator {
	
	public boolean ValidateCard(String cardNo, String date) {
		
		boolean masterFlag = true;
		
		boolean checkNoOfDigits = checkNoOfDigits(cardNo);
		boolean cheackStartsWith = cheackStartsWith(cardNo);
		boolean validateLuhn = validateLuhn(cardNo);
		boolean validateDateType = validateDateType(date);
		boolean validateExpiry = validateExpiry(date);
		
		if(checkNoOfDigits==false || cheackStartsWith==false || validateLuhn==false ||validateDateType==false ||validateExpiry==false) {
			masterFlag =false;
		}
		
		return masterFlag;
	}
	
	/*All card numbers have 16 digits.
	• Card numbers can optionally include spaces every 4 digits.
	• Visa card numbers start with a 4.
	• MasterCard card numbers start with the numbers 51 through 55.
	• The final digit of the card (verification digit) must be validated against the
	Luhn formula.
	• Expiration dates must use the format MM/YY (e.g. 01/19 represents
	January 2019).
	• Expiration dates must be in the future*/
	
	private boolean checkNoOfDigits(String cardNo) {		
		boolean flag = true;
		if(!(cardNo.replace(" ", "").length()==16)) {
			flag = false;
		}
		return flag;
	}
	
	
	
	public static void main (String[] args) {
		cheackStartsWith("4714 4385 3852 3845");
		
	}
	
	
	private static boolean cheackStartsWith(String cardNo) {
		boolean flag = false;
		
		if((cardNo.replace(" ", "").matches("^5[12345]\\d+$") || cardNo.replace(" ", "").matches("^4\\d+$")) && cardNo.matches("^\\d{4}(?: ?\\d+)*$")) {
			flag = true;
		}
		System.out.println(flag);
		return flag;
	}
	
	
	private boolean validateLuhn(String str) {
		
		boolean flag = true;
		str = str.replace(" ", "");
		int[] ints = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			ints[i] = Integer.parseInt(str.substring(i, i + 1));
		}
		for (int i = ints.length - 2; i >= 0; i = i - 2) {
			int j = ints[i];
			j = j * 2;
			if (j > 9) {
				j = j % 10 + 1;
			}
			ints[i] = j;
		}
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		if (sum % 10 == 0) {
			flag=true;
		} else {
			flag=false;
		}
		
		return flag;
	}
	
	private boolean validateDateType(String date) {
		boolean flag = true;
		if(!(date.matches("(?:0[1-9]|1[0-2])/[0-9]{2}"))){
			flag=false;
		}
		return flag;
	}
	
	private boolean validateExpiry(String date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
		simpleDateFormat.setLenient(false);
		Date expiry = null;
		try {
			expiry = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean expired = expiry.before(new Date());
		return !expired;
	}

}
