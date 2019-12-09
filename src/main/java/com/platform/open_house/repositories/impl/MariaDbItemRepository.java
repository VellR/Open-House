package com.platform.open_house.repositories.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.platform.open_house.models.Item;
import com.platform.open_house.repositories.ItemRepository;

@Repository("mariaDbItemRepository")
public class MariaDbItemRepository implements ItemRepository{
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	@Override
	public Integer createItem(Item item) {
		Integer id = -1;
		
		 Date expiration = null;
		    String date = item.getExpiration().replace("-", "/");
			try {
				expiration = new SimpleDateFormat("yyyy/MM/dd").parse(date);
			} catch (ParseException e) {
				System.out.println("Date error: " + e.getMessage());
				e.printStackTrace();
			} 


		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userId", item.getUserId());
		params.addValue("name", item.getName());
		params.addValue("description", item.getDescription());
		params.addValue("price", item.getPrice());
		params.addValue("expiration", new java.sql.Date(expiration.getTime()));

		String createItemSql = "INSERT INTO items (userId, name, description,"
				+ " price, expiration) VALUES "
				+ "(:userId, :name, :description, :price, :expiration)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createItemSql, 
				params, keyHolder);

		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		
		return id;
	}

	@Override
	public Item getItemById(Integer id) throws SQLException {
		String selectItemById = "SELECT * FROM items WHERE itemId = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Item item = null;
		try{

			item = (Item)mariaDbJdbcTemplate.queryForObject(
					selectItemById, params, new ItemMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
		}
		
		return item;
	}

	@Override
	public List<Item> getAllItems() throws ClassNotFoundException, IOException, SQLException {
		String selectItems = "SELECT * FROM items";

		List<Item> result = mariaDbJdbcTemplate.query(selectItems, new ItemMapper());
		return result;
	}
	
	@Override
	public List<Item> getAllItemsByUserId(Integer userId) {
		String selectItems = "SELECT * FROM items WHERE userId=" + userId;

		List<Item> result = mariaDbJdbcTemplate.query(selectItems, new ItemMapper());
		return result;
	}
	
	@Override
	public List<Item> getAllItemsNotByUserId(Integer userId){
		String selectItems = "SELECT * FROM items WHERE userId != " + userId;

		List<Item> result = mariaDbJdbcTemplate.query(selectItems, new ItemMapper());
		return result;
	}

	@Override
	public Boolean updateItem(Item item) {
		Integer result;
		Map<String, Object> params = new HashMap<>();
		params.put("itemId", item.getId());
		params.put("userId", item.getUserId());
		params.put("name", item.getName());
		params.put("description", item.getDescription());
		params.put("price", item.getPrice());
		params.put("expiration", item.getExpiration());
		
		String updateSql = "UPDATE items SET itemId = :itemId, userId = :userId,"
				+ " name = :name, description = :description, price = :price,"
				+ " expiration = :expiration";
		
		result = mariaDbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteItem(Integer itemId) {
		Integer result;
		String deleteSql = "DELETE FROM items WHERE itemId = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", itemId);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	private final class ItemMapper implements RowMapper<Item> {
		@Override
		public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
			Item item = new Item();
			
			Date date = new java.util.Date(rs.getDate(6).getTime());  
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
			String expiration = formatter.format(date); 
			
			item.setId(rs.getInt(1));
			item.setUserId(rs.getInt(2));
			item.setName(rs.getString(3));
			item.setDescription(rs.getString(4));
			item.setPrice(rs.getString(5));
			item.setExpiration(expiration);
			return item;
		}
	}

}
