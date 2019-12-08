package com.platform.open_house.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.platform.open_house.models.User;

public interface UserRepository {
	Integer createUser(User user);
	
	User loginUser(String username, String password);
	User getUserById(Integer id) throws SQLException;
	User getUserByUsername(String username);
	
	List<User> getAllUsers() throws ClassNotFoundException, IOException, SQLException;
	
	Boolean updateUser(User user);
	Boolean deleteUser(Integer userId);
}
