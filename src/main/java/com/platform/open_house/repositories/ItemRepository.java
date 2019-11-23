package com.platform.open_house.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.platform.open_house.models.Item;

public interface ItemRepository {
	Integer createItem(Item item);
	Item getItemById(Integer id) throws SQLException;
	
	List<Item> getAllItems() throws ClassNotFoundException, IOException, SQLException;
	List<Item> getAllItemsByUserId(Integer userId);
	
	Boolean updateItem(Item item);
	Boolean deleteItem(Integer itemId);
}
