package com.springnew.spring.creditcardvalidator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.springnew.spring.creditcardvalidator.CreditCard;

@RestController
public class CreditCardController {
	
	@Autowired
	private CreditCard card;
	
	@Autowired CreditCardModel cardmodel;
	
	@RequestMapping(value = { "/card/validate" }, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<String> updatePerson(@RequestBody String carddetails) {

		List<String> blacklist = cardmodel.validateCard(carddetails);
		
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		JsonArray balcklistArr = gson.toJsonTree(blacklist).getAsJsonArray();
		
		jsonObject.add("blacklist",balcklistArr);
		
		return new ResponseEntity<String>( jsonObject.toString(), HttpStatus.OK );

	}
	
}
