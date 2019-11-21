package com.platform.open_house.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.platform.open_house.models.Barter;

public interface BarterRepository {
	Integer createBarter(Barter barter);
	Barter getBarterById(Integer id) throws SQLException;
	
	List<Barter> getAllBarters() throws ClassNotFoundException, IOException, SQLException;
	
	Boolean updateBarter(Barter barter);
	Boolean deleteBarter(Integer barterId);
}
