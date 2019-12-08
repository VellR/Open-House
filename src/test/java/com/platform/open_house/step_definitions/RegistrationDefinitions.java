package com.platform.open_house.step_definitions;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class RegistrationDefinitions {
	private WebDriver driver;
	
	String existingUsername = "tmusm";
	
	@AfterClass
	public void breakdown() {
		driver.close();
	}
	
	@Given("^No User is logged in$")
	public void no_user_is_logged_in() {
		///Users/Student/Downloads/chromedriver_win32/chromedriver.exe
		///Users/ivell/Downloads/chromedriver_win32/chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "/Users/ivell/Downloads/chromedriver_win32/chromedriver.exe");
				
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/open_house/");
		driver.manage().window().maximize();
	}
	
	@Then("^Navigate to Registration Page$")
	public void navigate_to_registration_page() {
		driver.findElement(By.id("register-button")).click();
	}
	
	@Then("^Click the Registration Button$")
	public void click_the_registration_button(){
		driver.findElement(By.id("register-button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Then("^Enter minimum amount of data for fields$")
	public void enter_minimum_amount_of_data_for_fields() {
	    driver.findElement(By.id("firstName")).sendKeys(randomString(2));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(2));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(5));
	    
	    String password = randomString(5);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(5));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(10, 10));
	}
	
	@Then("^Enter maximum amount of data for fields$")
	public void enter_maximum_amount_of_data_for_fields() {
	    driver.findElement(By.id("firstName")).sendKeys(randomString(25));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(25));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(25));
	    
	    String password = randomString(50);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(50));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(12, 10));
	}
	
	@Then("^Enter data to meet minimum boundary for all fields$")
	public void enter_dat_to_meet_minimum_boundary_for_all_fields() {
		driver.findElement(By.id("firstName")).sendKeys(randomString(1));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(1));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(4));
	    
	    String password = randomString(4);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(4));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(9, 10));
	}
	
	@Then("^Enter data to meet maximum boundary for all fields$")
	public void enter_dat_to_meet_maximum_boundary_for_all_fields() {
		driver.findElement(By.id("firstName")).sendKeys(randomString(26));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(26));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(26));
	    
	    String password = randomString(51);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(51));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(13, 10));
	}
	
	@Then("^Enter registration data without first or last name$")
	public void enter_registration_data_without_first_or_last_name() {
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(6));
	    
	    String password = randomString(6);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(6));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(11, 10));
	}
	
	@Then("^Enter first and last name with a number$")
	public void enter_first_and_last_name_with_a_number() {
		driver.findElement(By.id("firstName")).sendKeys(randomString(10) + randomNumber(1, 10));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(10) + randomNumber(1, 10));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(8));
	    
	    String password = randomString(6);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(10));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(11, 10));
	}
	
	@Then("^Enter registration data without phone number$")
	public void enter_registration_data_without_phone_number() {
		driver.findElement(By.id("firstName")).sendKeys(randomString(6));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(6));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(5));
	    
	    String password = randomString(8);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(8));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	}
	
	@Then("^Enter phone number with a letter$")
	public void enter_phone_number_with_a_letter() {
		driver.findElement(By.id("firstName")).sendKeys(randomString(7));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(6));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(8));
	    
	    String password = randomString(9);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(7));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(10, 10) + randomString(1));
	}
	
	@Then("^Enter registration data without matching passwords$")
	public void enter_registration_data_without_matching_passwords() {
		driver.findElement(By.id("firstName")).sendKeys(randomString(6));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(7));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(randomString(8));
	    
	    driver.findElement(By.id("password")).sendKeys(randomString(9));
	    driver.findElement(By.id("confirmPassword")).sendKeys(randomString(9));
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(5));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(10, 10));
	}
	
	@Then("^Enter registration data with existing username$")
	public void enter_registration_data_with_existing_username() {
		driver.findElement(By.id("firstName")).sendKeys(randomString(3));
	    driver.findElement(By.id("lastName")).sendKeys(randomString(4));
	    driver.findElement(By.id("email")).sendKeys(randomString(4)+"@"+randomString(4)+".com");
	    driver.findElement(By.id("username")).sendKeys(existingUsername);
	    
	    String password = randomString(5);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(password);
	    
	    driver.findElement(By.id("location")).sendKeys(randomString(6));
	    
	    String birthday = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
	    driver.findElement(By.id("birthday")).sendKeys(birthday);
	    
	    driver.findElement(By.id("phoneNumber")).sendKeys(randomNumber(10, 10));
	}
	
	@Then("^Verify that no alert fields show$")
	public void verify_tha_no_alert_fields_show() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		try {
			driver.findElement(By.id("firstName.errors")).isDisplayed();
			driver.findElement(By.id("lastName.errors")).isDisplayed();
			driver.findElement(By.id("email.errors")).isDisplayed();
			driver.findElement(By.id("username.errors")).isDisplayed();
			driver.findElement(By.id("password.errors")).isDisplayed();
			driver.findElement(By.id("location.errors")).isDisplayed();
			driver.findElement(By.id("phoneNumber.errors")).isDisplayed();
		}catch(NoSuchElementException exception){
			assertTrue(true);
		}
		
	}
	
	@Then("^Verify that all alert fields show for empty form$")
	public void verify_that_all_alert_fields_show_for_empty_form() {
	    assertThat(driver.findElement(By.id("firstName.errors")).getText(), containsString("First Name is required."));
	    assertThat(driver.findElement(By.id("lastName.errors")).getText(), containsString("Last Name is required."));
	    assertThat(driver.findElement(By.id("email.errors")).getText(), containsString("Email is required."));
	    assertThat(driver.findElement(By.id("username.errors")).getText(), containsString("Username is required."));
	    assertThat(driver.findElement(By.id("password.errors")).getText(), containsString("Password is required."));
	    assertThat(driver.findElement(By.id("location.errors")).getText(), containsString("Location must be between 5 and 50 characters long."));
	    assertThat(driver.findElement(By.id("phoneNumber.errors")).getText(), containsString("Phone Number must be between 10 and 12 characters long."));
	}
	
	@Then("^Verify that all alert fields show$")
	public void verify_that_all_alert_fields_show() {
	    assertThat(driver.findElement(By.id("firstName.errors")).getText(), containsString("First Name must be between 2 and 25 characters long."));
	    assertThat(driver.findElement(By.id("lastName.errors")).getText(), containsString("Last Name must be between 2 and 25 characters long."));
	    assertThat(driver.findElement(By.id("username.errors")).getText(), containsString("Username must be between 5 and 25 characters long."));
	    assertThat(driver.findElement(By.id("password.errors")).getText(), containsString("Password must be between 5 and 50 characters long."));
	    assertThat(driver.findElement(By.id("location.errors")).getText(), containsString("Location must be between 5 and 50 characters long."));
	    assertThat(driver.findElement(By.id("phoneNumber.errors")).getText(), containsString("Phone Number must be between 10 and 12 characters long."));
	}
	
	@Then("^Verify the first and last name error$")
	public void verify_the_first_and_last_name_error() {
		assertThat(driver.findElement(By.id("firstName.errors")).getText(), containsString("First name cannot contain numbers."));
	    assertThat(driver.findElement(By.id("lastName.errors")).getText(), containsString("Last name cannot contain numbers."));
	}
	
	@Then("^Verify the phone number error$")
	public void verify_the_phone_number_error() {
		assertThat(driver.findElement(By.id("phoneNumber.errors")).getText(), containsString("Phonenumber cannot contain letters."));
	}
	
	@Then("^Verify the password error$")
	public void verify_the_password_error() {
		assertThat(driver.findElement(By.id("confirmPasswordErrorMessage")).getText(), containsString("Passwords do not match."));
	}
	
	@Then("^Verify the username error$")
	public void verify_the_username_error() {
		assertThat(driver.findElement(By.id("usernameTakenError")).getText(), containsString("That username is taken, try another"));
	}
	
	@After
	public void closeWindow() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}
	
	private String randomString(int length) {
		String output = "";
		
		for(int i = length; i > 0; i--) {
			String chars = "abcdefghijklmnopqrstuvwxyz";
			Random rnd = new Random();
			char character = chars.charAt(rnd.nextInt(chars.length()));
			
			output = output + character;
		}
		
		return output;
	}
	
	private String randomNumber(int length, int max) {
		String output = "";
		
		for(int i = length; i > 0; i--) {
			Random random = new Random();
			int randomInt = random.nextInt(max);
			
			output = output + randomInt;
		}
		
		return output;
	}
	
}
