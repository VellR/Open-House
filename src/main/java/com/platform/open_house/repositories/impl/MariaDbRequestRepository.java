package com.platform.open_house.repositories.impl;

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

import com.platform.open_house.models.Request;
import com.platform.open_house.repositories.RequestRepository;

@Repository("mariaDbRequestRepository")
public class MariaDbRequestRepository implements RequestRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	@Override
	public Integer createRequest(Request request) {
		Integer id = -1;

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userId", request.getUserId());
		params.addValue("itemName", request.getName());
		params.addValue("itemDescription", request.getDescription());
		params.addValue("itemPrice", request.getPrice());
		params.addValue("barter", request.getBarter());
		params.addValue("barterItem", request.getBarterItem());

		String createRequestSql = "INSERT INTO requests (userId, itemName, itemDescription,"
				+ " itemPrice, barter, barterItem) VALUES "
				+ "(:userId, :itemName, :itemDescription, :itemPrice, :barter, :barterItem)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createRequestSql, 
				params, keyHolder);

		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		
		return id;
	}

	@Override
	public Request getRequestById(Integer id) throws SQLException {
		String selectRequestById = "SELECT * FROM requests WHERE requestId = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Request request = null;
		try{

			request = (Request)mariaDbJdbcTemplate.queryForObject(
					selectRequestById, params, new RequestMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
		}
		
		return request;
	}

	@Override
	public List<Request> getAllRequest() {
		String selectRequests = "SELECT * FROM requests";

		List<Request> result = mariaDbJdbcTemplate.query(selectRequests, new RequestMapper());
		return result;
	}

	@Override
	public List<Request> getAllRequestByUserId(Integer userId) {
		String selectRequests = "SELECT * FROM requests WHERE userId=" + userId;

		List<Request> result = mariaDbJdbcTemplate.query(selectRequests, new RequestMapper());
		return result;
	}

	@Override
	public List<Request> getAllRequestNotByUserId(Integer userId) {
		String selectRequests = "SELECT * FROM requests WHERE userId != " + userId;

		List<Request> result = mariaDbJdbcTemplate.query(selectRequests, new RequestMapper());
		return result;
	}

	@Override
	public Boolean updateRequest(Request request) {
		Integer result;
		
		Map<String, Object> params = new HashMap<>();
		params.put("requestId", request.getId());
		params.put("userId", request.getUserId());
		params.put("itemName", request.getName());
		params.put("itemDescription", request.getDescription());
		params.put("itemPrice", request.getPrice());
		params.put("barter", request.getBarter());
		params.put("barterItem", request.getBarterItem());
		
		String updateSql = "UPDATE requests SET requestId = :requestId, userId = :userId,"
				+ " itemName = :itemName, itemDescription = :itemDescription, itemPrice = :itemPrice,"
				+ " barter = :barter, barterItem = :barterItem";
		
		result = mariaDbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteRequest(Integer requestId) {
		Integer result;
		String deleteSql = "DELETE FROM requests WHERE requestId = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", requestId);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	private final class RequestMapper implements RowMapper<Request> {
		@Override
		public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
			Request request = new Request();
			
			request.setId(rs.getInt(1));
			request.setUserId(rs.getInt(2));
			request.setName(rs.getString(3));
			request.setDescription(rs.getString(4));
			request.setPrice(rs.getDouble(5));
			request.setBarter(rs.getBoolean(6));
			request.setBarterItem(rs.getString(7));
			
			return request;
		}
	}

}
