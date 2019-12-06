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

import com.platform.open_house.models.User;
import com.platform.open_house.repositories.UserRepository;

@Repository("mariaDbUserRepository")
public class MariaDbUserRepository implements UserRepository{
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	@Override
	public Integer createUser(User user) {
		Integer id = -1;
		
	    Date birthday = null;
	    String date = user.getBirthday().replace("-", "/");
		try {
			birthday = new SimpleDateFormat("yyyy/MM/dd").parse(date);
		} catch (ParseException e) {
			System.out.println("Date error: " + e.getMessage());
			e.printStackTrace();
		} 

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("firstName", user.getFirstName());
		params.addValue("lastName", user.getLastName());
		params.addValue("username", user.getUsername());
		params.addValue("password", user.getPassword());
		params.addValue("location", user.getLocation());
		params.addValue("phoneNumber", user.getPhoneNumber());
		params.addValue("email", user.getEmail());
		params.addValue("birthday", new java.sql.Date(birthday.getTime()));

		String createUserSql = "INSERT INTO users (firstName, lastName, username,"
				+ " password, location, phoneNumber, email, birthday) VALUES "
				+ "(:firstName, :lastName, :username, :password, :location,"
				+ " :phoneNumber, :email, :birthday)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createUserSql, 
				params, keyHolder);

		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		
		return id;
	}

	@Override
	public User loginUser(String username, String password) {
		String selectUserUsernamePassword = "SELECT * FROM users WHERE (username = :username AND password = :password)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		params.put("password", password);
		
		User user = null;
		try{
			user = (User)mariaDbJdbcTemplate.queryForObject(
					selectUserUsernamePassword, params, new UserMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
		}
		
		return user;
	}
	
	@Override
	public User getUserById(Integer id) throws SQLException {
		String selectUserById = "SELECT * FROM users WHERE userId = :id";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		User user = null;
		try{

			user = (User)mariaDbJdbcTemplate.queryForObject(
					selectUserById, params, new UserMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() throws ClassNotFoundException, IOException, SQLException {
		String selectUsers = "SELECT * FROM users";

		List<User> result = mariaDbJdbcTemplate.query(selectUsers, new UserMapper());
		return result;
	}

	@Override
	public Boolean updateUser(User user) {
		Integer result;
		Map<String, Object> params = new HashMap<>();
		params.put("userId", user.getUserId());
		params.put("firstName", user.getFirstName());
		params.put("lastName", user.getLastName());
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		params.put("location", user.getLocation());
		params.put("phoneNumber", user.getPhoneNumber());
		params.put("email", user.getEmail());
		params.put("birthday", user.getBirthday());
		
		String updateSql = "UPDATE users SET firstName = :firstName,"
				+ " lastName = :lastName, username = :username, password = :password,"
				+ " location = :location, phoneNumber = :phoneNumber, email = :email,"
				+ " birthday = :birthday"
				+ " WHERE(userId = :userId)";
		
		result = mariaDbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		Integer result;
		String deleteSql = "DELETE FROM users WHERE userId = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", userId);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	private final class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			
			Date date = new java.util.Date(rs.getDate(9).getTime());  
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
			String birthday = formatter.format(date); 			
			
			user.setUserId(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setUsername(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setLocation(rs.getString(6));
			user.setPhoneNumber(rs.getString(7));
			user.setEmail(rs.getString(8));
			user.setBirthday(birthday);
			
			return user;
		}
	}

}
