package com.platform.open_house.repositories.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.platform.open_house.models.Trade;
import com.platform.open_house.repositories.TradeRepository;

@Repository("mariaDbTradeRepository")
public class MariaDbTradeRepository implements TradeRepository{
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	@Override
	public Integer createTrade(Trade trade) {
		Integer id = -1;

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("tradeId", trade.getTradeId());
		params.addValue("itemId", trade.getItemId());
		params.addValue("sellerId", trade.getSellerId());
		params.addValue("buyerId", trade.getBuyerId());

		String createTradeSql = "INSERT INTO trades (tradeId, itemId, sellerId, buyerId) VALUES "
				+ "(:tradeId, :itemId, :sellerId, :buyerId)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createTradeSql, 
				params, keyHolder);

		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		
		return id;
	}
	
	@Override
	public List<Trade> getAllTradesBySellerId(int userId) {
		String selectTrades = "SELECT * FROM trades WHERE sellerId=" + userId;

		List<Trade> result = mariaDbJdbcTemplate.query(selectTrades, new TradeMapper());
		return result;
	}

	@Override
	public Trade getTradeById(Integer id) throws SQLException {
		String selectTradeById = "SELECT * FROM trades WHERE tradeId = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Trade trade = null;
		try{

			trade = (Trade)mariaDbJdbcTemplate.queryForObject(
					selectTradeById, params, new TradeMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
		}
		
		return trade;
	}

	@Override
	public List<Trade> getAllTrades() throws ClassNotFoundException, IOException, SQLException {
		String selectTrades = "SELECT * FROM trades";

		List<Trade> result = mariaDbJdbcTemplate.query(selectTrades, new TradeMapper());
		return result;
	}

	@Override
	public Boolean updateTrade(Trade trade) {
		Integer result;
		Map<String, Object> params = new HashMap<>();
		params.put("tradeId", trade.getTradeId());
		params.put("itemId", trade.getItemId());
		params.put("sellerId", trade.getSellerId());
		params.put("buyerId", trade.getBuyerId());
		
		String updateSql = "UPDATE trades SET tradeId = :tradeId, itemId = :itemId, sellerId = :sellerId,"
				+ " buyerId = :buyerId";
		
		result = mariaDbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteTrade(Integer tradeId) {
		Integer result;
		String deleteSql = "DELETE FROM trades WHERE tradeId = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", tradeId);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	private final class TradeMapper implements RowMapper<Trade> {
		@Override
		public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
			Trade trade = new Trade();
			trade.setTradeId(rs.getInt(1));
			trade.setItemId(rs.getInt(2));
			trade.setSellerId(rs.getInt(3));
			trade.setBuyerId(rs.getInt(4));
			return trade;
		}
	}

	

}
