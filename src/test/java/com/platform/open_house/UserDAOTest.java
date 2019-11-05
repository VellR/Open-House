package com.platform.open_house;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDAOTest {
	
	static UserDAO userDao;
	static User user;
	
	static String firstname;
	static String lastname;
	static String username;
	static String password;
	static String location;
	static String phonenumber;
	static String email;
	static Date birthday;
	static int id;
	
	

	@BeforeClass
	public static void setup() {
		userDao = new UserDAO();
		
		long millis=System.currentTimeMillis(); 
		firstname = "Ivell";
		lastname = "Romas";
		username = "ivellR";
		password = "passpass1";
		location = "New Orleans";
		phonenumber = "1-800-432-6534";
		email = "ivellromas@gmail.com";
		birthday = new java.sql.Date(millis);;
		id = 1;
		
		user = new User(id, firstname, lastname, username, password, location, phonenumber, email, birthday);
	}
	
//	@AfterClass
//	public static void cleanup() {
//		userDao.removeUser(id);
//	}
	
	@Test
	public void addTest() {
		userDao.addUser(user);
		assumeTrue(userDao.userExist(id));
		
	}
	
	@Test
	public void getTest() {
		User actualUser = userDao.requestUser(id);
		assumeThat(user.getUsername(), is(actualUser.getUsername()));
	}
	
	@Test
	public void updateTest() {
		String originalUsername = username;
		username = "changed Name";
		
		user = new User(id, firstname, lastname, username, password, location, phonenumber, email, birthday);
		userDao.updateUser(user);
		
		username = userDao.requestUser(id).getUsername();
		
		assumeThat(username, not(originalUsername));
	}
	
	@Test
	public void removeTest() {
		userDao.removeUser(id);
		assumeFalse(userDao.userExist(id));
	}

}
