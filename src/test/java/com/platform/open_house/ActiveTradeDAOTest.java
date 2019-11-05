package com.platform.open_house;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class ActiveTradeDAOTest {

	static Item item;
	static ActiveTradeDAO activeTradeDao;
	
	static int ownerId;
	static int tradeId;
	static int buyerId;
	static int itemId;
	static String name;
	static String description;
	static double price;
	static boolean barter;
	static String desiredBarter;
	static Date expiration;
	
	@BeforeClass
	public static void setup() {
		activeTradeDao = new ActiveTradeDAO();
		
		long millis=System.currentTimeMillis(); 
		
		ownerId = 1;
		tradeId = 1;
		buyerId = 1;
		itemId = 1;
		name = "Shoe";
		description = "This is a shoe.";
		price = 4.23;
		barter = false;
		desiredBarter = "";
		expiration = new java.sql.Date(millis);  
		
		item = new Item(ownerId, tradeId, buyerId, itemId, name, description, price, barter, desiredBarter, expiration);
	}
	
	@Test
	public void addTest() {
		activeTradeDao.addActiveTrade(item);
		assumeTrue(activeTradeDao.activeTradeExist(tradeId));
		
	}
	
	@Test
	public void getTest() {
		Item actualItem = activeTradeDao.getActiveTrade(tradeId);
		assumeThat(item.getName(), is(actualItem.getName()));
	}
	
	@Test
	public void updateTest() {
		String originalName = name;
		name = "changed Name";
		
		item = new Item(ownerId, tradeId, buyerId, itemId, name, description, price, barter, desiredBarter, expiration);
		activeTradeDao.updateActiveTrade(item);
		
		name = activeTradeDao.getActiveTrade(tradeId).getName();
		
		assumeThat(name, not(originalName));
	}
	
	@Test
	public void removeTest() {
		activeTradeDao.removeActiveTrade(tradeId);	
		assumeFalse(activeTradeDao.activeTradeExist(tradeId));
	}

}
