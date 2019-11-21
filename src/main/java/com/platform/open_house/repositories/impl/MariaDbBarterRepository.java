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

import com.platform.open_house.models.Barter;
import com.platform.open_house.repositories.BarterRepository;

@Repository("mariaDbBarterRepository")
public class MariaDbBarterRepository implements BarterRepository{
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	@Override
	public Integer createBarter(Barter barter) {
		Integer id = -1;

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("barterId", barter.getBarterId());
		params.addValue("sellerItemId", barter.getSellerItemId());
		params.addValue("buyerItemId", barter.getBuyerItemId());

		String createItemSql = "INSERT INTO barters (barterId, sellerItemId, buyerItemId) VALUES "
				+ "(:barterId, :sellerItemId, :buyerItemId)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createItemSql, 
				params, keyHolder);

		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		
		return id;
	}

	@Override
	public Barter getBarterById(Integer id) throws SQLException {
		String selectItemById = "SELECT * FROM barters WHERE barterId = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Barter barter = null;
		try{

			barter = (Barter)mariaDbJdbcTemplate.queryForObject(
					selectItemById, params, new BarterMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
		}
		
		return barter;
	}

	@Override
	public List<Barter> getAllBarters() throws ClassNotFoundException, IOException, SQLException {
		String selectBarters = "SELECT * FROM barters";

		List<Barter> result = mariaDbJdbcTemplate.query(selectBarters, new BarterMapper());
		return result;
	}

	@Override
	public Boolean updateBarter(Barter barter) {
		Integer result;
		Map<String, Object> params = new HashMap<>();
		params.put("barterId", barter.getBarterId());
		params.put("sellerItemId", barter.getSellerItemId());
		params.put("buyerItemId", barter.getBuyerItemId());
		
		String updateSql = "UPDATE barters SET barterId = :barterId, sellerItemId = :sellerItemId,"
				+ " buyerItemId = :buyerItemId";
		
		result = mariaDbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteBarter(Integer barterId) {
		Integer result;
		String deleteSql = "DELETE FROM barters WHERE barterId = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", barterId);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	private final class BarterMapper implements RowMapper<Barter> {
		@Override
		public Barter mapRow(ResultSet rs, int rowNum) throws SQLException {
			Barter barter = new Barter();
			barter.setBarterId(rs.getInt(1));
			barter.setSellerItemId(rs.getInt(2));
			barter.setBuyerItemId(rs.getInt(3));
			return barter;
		}
	}

}
