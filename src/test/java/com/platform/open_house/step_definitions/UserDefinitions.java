package com.platform.open_house.step_definitions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.platform.open_house.models.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class UserDefinitions {
	private WebDriver driver;
	User userModel = new User("testtesttest", "testtesttest", "testtesttest",
			"testtesttest", "testtesttest", "2222222222",
			"testtesttest@test.com", "0002-02-02");
	
	@AfterClass
	public void breakdown() {
		driver.close();
	}
	
	@Given("^no User is logged in$")
	public void no_user_is_logged_in() {
		System.setProperty("webdriver.chrome.driver", "/Users/Student/Downloads/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/open_house/");
		driver.manage().window().maximize();
		
		assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("Open House\\\\nLogin Page"));
	}
	
	@Then("^register a New User$")
	public void register_a_New_User() {
		driver.findElement(By.cssSelector(".btn-secondary")).click();
		
	    driver.findElement(By.id("firstName")).sendKeys(userModel.getFirstName());
	    driver.findElement(By.id("lastName")).sendKeys(userModel.getLastName());
	    driver.findElement(By.id("email")).sendKeys(userModel.getEmail());
	    driver.findElement(By.id("username")).sendKeys(userModel.getUsername());
	    driver.findElement(By.id("password")).sendKeys(userModel.getPassword());
	    driver.findElement(By.cssSelector(".form-group:nth-child(7) #password")).sendKeys(userModel.getPassword());
	    driver.findElement(By.id("location")).sendKeys(userModel.getLocation());
	    driver.findElement(By.id("birthday")).sendKeys(userModel.getBirthday());
	    driver.findElement(By.id("phoneNumber")).sendKeys(userModel.getPhoneNumber());
	    
	    driver.findElement(By.cssSelector(".btn")).click();
	}
	
	@Then("^Login with that User's credentials$")
	public void login_with_that_users_credentials() {
	    driver.findElement(By.id("username")).sendKeys(userModel.getUsername());
	    driver.findElement(By.id("password")).sendKeys(userModel.getPassword());
	    
	    driver.findElement(By.cssSelector(".btn-black")).click();
	}
	
	@Then("^verify that the User is on the feed page$")
	public void verify_that_the_user_is_on_the_feed_page() {
		assertThat(driver.getTitle(), is("Home"));
	}
}
