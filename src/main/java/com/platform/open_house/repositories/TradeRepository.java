package com.platform.open_house.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.platform.open_house.models.Trade;

public interface TradeRepository {
	Integer createTrade(Trade item);
	Trade getTradeById(Integer id) throws SQLException;
	
	List<Trade> getAllTrades() throws ClassNotFoundException, IOException, SQLException;
	List<Trade> getAllTradesBySellerId(int userId);
	
	Boolean updateTrade(Trade item);
	Boolean deleteTrade(Integer tradeId);
}
