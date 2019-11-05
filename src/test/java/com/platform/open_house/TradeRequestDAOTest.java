package com.platform.open_house;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TradeRequestDAOTest {

	static TradeRequest tradeRequest;
	static TradeRequestDAO tradeRequestDao;
	
	static int requestId;
	static String name;
	static double price;
	static String description;
	static boolean barter;
	static String desiredBarter;
	
	
	@BeforeClass
	public static void setup() {
		tradeRequestDao = new TradeRequestDAO();
		
		requestId = 1;
		name = "Hover Board";
		price = 200.54;
		description= "It's from the future";
		barter = true;
		desiredBarter = "Flux Capacitor";
		
		tradeRequest = new TradeRequest(requestId, name, price, description, barter, desiredBarter);
	}
	
	@Test
	public void addTest() {
		tradeRequestDao.addTradeRequest(tradeRequest);
		assumeTrue(tradeRequestDao.tradeRequestExist(requestId));
		
	}
	
	@Test
	public void getTest() {
		TradeRequest actualTradeRequest = tradeRequestDao.getTradeRequest(requestId);
		assumeThat(tradeRequest.getName(), is(actualTradeRequest.getName()));
	}
	
	@Test
	public void updateTest() {
		String originalName = name;
		name = "changed Name";
		
		tradeRequest = new TradeRequest(requestId, name, price, description, barter, desiredBarter);
		tradeRequestDao.updateTradeRequest(tradeRequest);
		
		name = tradeRequestDao.getTradeRequest(requestId).getName();
		
		assumeThat(name, not(originalName));
	}
	
	@Test
	public void removeTest() {
		tradeRequestDao.removeTradeRequest(requestId);	
		assumeFalse(tradeRequestDao.tradeRequestExist(requestId));
	}

}
