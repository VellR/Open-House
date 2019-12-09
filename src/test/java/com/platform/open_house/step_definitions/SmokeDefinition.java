package com.platform.open_house.step_definitions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.platform.open_house.models.Request;
import com.platform.open_house.models.User;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class SmokeDefinition {
	private WebDriver driver;
	
	private User user1 = new User("John", "Doe", "joedoe", "test1234", "Dallas, Texas", "2141234567", "johndoe@test.com", "12081997");
	private User user2 = new User("Jane", "Doe", "janedoe", "test1234", "Dallas, Texas", "4691234567", "janedoe@test.com", "03031993");
	private Request modelRequest= new Request("Test Request", "Test Request Description", "1.11", true, "Test Barter Item");
	
	String passwordChange = "changetest";
	
	@Before
	public void openWindow() {
		///Users/Student/Downloads/chromedriver_win32/chromedriver.exe
		///Users/ivell/Downloads/chromedriver_win32/chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "/Users/Student/Downloads/chromedriver_win32/chromedriver.exe");
						
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/open_house/");
	}
	
	@After
	public void closeWindow() {
		driver.quit();
	}
	
	@Given("^User One does not exist$")
	public void user_one_does_not_exist() {
		///Users/Student/Downloads/chromedriver_win32/chromedriver.exe
		///Users/ivell/Downloads/chromedriver_win32/chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "/Users/Student/Downloads/chromedriver_win32/chromedriver.exe");
				
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/open_house/");
		driver.manage().window().maximize();
		
	    driver.findElement(By.id("username-input")).sendKeys(user1.getUsername());
	    driver.findElement(By.id("password-input")).sendKeys(user1.getPassword());
	    driver.findElement(By.id("login-button")).click();
	}
	
	@Given("^User Two does not exist$")
	public void user_two_does_not_exist() {
		///Users/Student/Downloads/chromedriver_win32/chromedriver.exe
		///Users/ivell/Downloads/chromedriver_win32/chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "/Users/Student/Downloads/chromedriver_win32/chromedriver.exe");
						
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/open_house/");
		driver.manage().window().maximize();
		
	    driver.findElement(By.id("username-input")).sendKeys("janedoe");
	    driver.findElement(By.id("password-input")).sendKeys(user2.getPassword());
	    
	    driver.findElement(By.id("login-button")).click();
	}
	
	@Then("^Register User One$")
	public void register_user_one() {
		driver.findElement(By.id("register-button")).click();
		
	    driver.findElement(By.id("firstName")).sendKeys(user1.getFirstName());
	    driver.findElement(By.id("lastName")).sendKeys(user1.getLastName());
	    driver.findElement(By.id("email")).sendKeys(user1.getEmail());
	    driver.findElement(By.id("username")).sendKeys(user1.getUsername());
	    driver.findElement(By.id("password")).sendKeys(user1.getPassword());
	    driver.findElement(By.id("confirmPassword")).sendKeys(user1.getPassword());
	    driver.findElement(By.id("location")).sendKeys(user1.getLocation());
	    driver.findElement(By.id("birthday")).sendKeys(user1.getBirthday());
	    driver.findElement(By.id("phoneNumber")).sendKeys(user1.getPhoneNumber());
	    
	    driver.findElement(By.id("register-button")).click();
	}
	
	@Then("^Register User Two$")
	public void register_user_two() {
		driver.findElement(By.id("register-button")).click();
		
	    driver.findElement(By.id("firstName")).sendKeys(user2.getFirstName());
	    driver.findElement(By.id("lastName")).sendKeys(user2.getLastName());
	    driver.findElement(By.id("email")).sendKeys(user2.getEmail());
	    driver.findElement(By.id("username")).sendKeys("janedoe");
	    driver.findElement(By.id("password")).sendKeys(user2.getPassword());
	    driver.findElement(By.id("confirmPassword")).sendKeys(user2.getPassword());
	    driver.findElement(By.id("location")).sendKeys(user2.getLocation());
	    driver.findElement(By.id("birthday")).sendKeys(user2.getBirthday());
	    driver.findElement(By.id("phoneNumber")).sendKeys(user2.getPhoneNumber());
	    
	    driver.findElement(By.id("register-button")).click();
	}
	
	@Then("^Login User One$")
	public void login_user_one() {
		driver.findElement(By.id("username-input")).sendKeys(user1.getUsername());
		driver.findElement(By.id("password-input")).sendKeys(user1.getPassword());
		  
		driver.findElement(By.id("login-button")).click();
		  
		assertThat(driver.getTitle(), is("Home"));
	}
	
	@Then("^Navigate to Items$")
	public void navigate_to_items() {
		driver.findElement(By.id("items-link")).click();
		assertThat(driver.getTitle(), is("My Items"));
		    
	}
	
	@Then("^Create Item$")
	public void create_item() {
	    driver.findElement(By.id("name")).sendKeys("Candle");
	    driver.findElement(By.id("description")).sendKeys("A wax candle");
	    driver.findElement(By.id("price")).sendKeys("1.11");
	    driver.findElement(By.id("expiration")).sendKeys("2020-01-01");
	    
	    driver.findElement(By.id("add-item-button")).click();
	    
	    driver.findElement(By.id("item-link-Candle")).click();
	    assertThat(driver.getTitle(), is("Candle"));
	}
	
	@Then("^Navigate to Requests$")
	public void navigate_to_requests() {
		driver.findElement(By.id("request-link")).click();
		assertThat(driver.getTitle(), is("Requested Items"));
	}
	
	@Then("^Create Request$")
	public void create_request() {
	    driver.findElement(By.id("name")).sendKeys("Matches");
	    driver.findElement(By.id("description")).sendKeys("A box of matches");
	    driver.findElement(By.id("price")).sendKeys("2.22");
	    driver.findElement(By.id("no")).click();
	    
	    driver.findElement(By.id("make-request-button")).click();
	    assertThat(driver.getTitle(), is("Matches"));
	}
	
	@Then("^Navigate to All Listed Items$")
	public void navigate_to_all_listed_items() {
		driver.findElement(By.id("all-items-link")).click();
	    assertThat(driver.getTitle(), is("Browse Items"));
	}
	
	@Then("^Verify Item is present$")
	public void verify_item_is_present() {
		driver.findElement(By.id("search-item-card-Candle")).click();
		assertThat(driver.getTitle(), is("Candle"));
	}
	
	@Then("^Navigate to Profile$")
	public void navigate_to_profile() {
		driver.findElement(By.id("profile-link")).click();
		assertThat(driver.getTitle(), is("Profile"));
	}
	
	@Then("^Modify Profile$")
	public void modify_profile() {
	    driver.findElement(By.id("email")).sendKeys("testchange@test.com");
	    driver.findElement(By.id("currentPassword")).sendKeys(user1.getPassword());
	    driver.findElement(By.id("password")).sendKeys("changetest");
	    driver.findElement(By.cssSelector(".form-group:nth-child(8) #password")).sendKeys("changetest");
	    driver.findElement(By.id("location")).sendKeys("Change, Texas");
	    driver.findElement(By.id("phoneNumber")).sendKeys("2147654321");
	    driver.findElement(By.id("update-profile-button")).click();
	    
	    assertThat(driver.getTitle(), is("Home"));
	}
	
	@Then("^Logout User One$")
	public void logout_user_one() {
		driver.findElement(By.id("logout-link")).click();
	    assertThat(driver.getTitle(), is("Login"));
	}
	
	@Then("^Verify that User One Profile is modified$")
	public void verify_that_user_one_profile_is_modified() {
		driver.findElement(By.id("username-input")).sendKeys(user1.getUsername());
	    driver.findElement(By.id("password-input")).sendKeys(passwordChange);
	    driver.findElement(By.id("login-button")).click();
	    
	    assertThat(driver.getTitle(), is("Home"));  
	}

	@Then("^Login User Two$")
	public void login_user_two() {
		driver.findElement(By.id("username-input")).sendKeys("janedoe");
		driver.findElement(By.id("password-input")).sendKeys(user2.getPassword());
		 
		driver.findElement(By.id("login-button")).click();
		assertThat(driver.getTitle(), is("Home"));
	}
	
	@Then("^Start trade with User One$")
	public void start_trade_with_user_one() {
		driver.findElement(By.id("feed-link")).click();
		driver.findElement(By.id("feed-item-Candle")).click();
		
	    assertThat(driver.getTitle(), is("Candle"));
	    driver.findElement(By.id("start-trade-button")).click();

	    assertThat(driver.getTitle(), is("My Trades"));
	}
	
	@Then("^Fulfill request for User One$")
	public void fulfill_request_for_user_one() {
		driver.findElement(By.id("feed-link")).click();
		driver.findElement(By.id("feed-request-Matches")).click();
		  
		assertThat(driver.getTitle(), is("Matches"));
		driver.findElement(By.id("fulfill-request-button")).click();
		  
		assertThat(driver.getTitle(), is("My Trades"));
	}
	
	@Then("^navigate to Request Page$")
	public void navigate_to_request_page() {
		driver.findElement(By.linkText("Item Request")).click();
	}
	
	@Then("^create a new request$")
	public void create_a_new_request() {
		driver.findElement(By.id("name")).sendKeys(modelRequest.getName());
		driver.findElement(By.id("description")).sendKeys(modelRequest.getDescription());
		driver.findElement(By.id("price")).sendKeys(modelRequest.getPrice().toString());
		
		if(modelRequest.getBarter()) {
			driver.findElement(By.id("yes")).click();
			driver.findElement(By.id("barterItem")).sendKeys(modelRequest.getBarterItem());
		}else {
			driver.findElement(By.id("no")).click();
		}
		
		driver.findElement(By.cssSelector(".btn")).click();
	}
	
	@Then("^verify that the request has been created$")
	public void verity_that_the_request_has_been_created() {
		 assertThat(driver.findElement(By.linkText("Test Request")).getText(), is(modelRequest.getName()));
		 assertThat(driver.findElement(By.cssSelector("small")).getText(), is(modelRequest.getPrice().toString()));
		 assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is(modelRequest.getDescription()));
		 assertThat(driver.findElement(By.cssSelector("p:nth-child(4)")).getText(), is(modelRequest.getBarterItem()));
		 
		 driver.findElement(By.cssSelector(".container")).click();
	}
}
