package com.platform.open_house.step_definitions;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class SmokeDefinition {
	private WebDriver driver;
	
	@AfterClass
	public void breakdown() {
		driver.close();
	}
	
	@Given("^User One does not exist$")
	public void user_one_does_not_exist() {
		
	}
	
	@Given("^User Two does not exist$")
	public void user_two_does_not_exist() {
		
	}
	
	@Then("^Register User One$")
	public void register_user_one() {
		
	}
	
	@Then("^Login User One$")
	public void login_user_one() {
		
	}
	
	@Then("^Navigate to Items$")
	public void navigate_to_items() {
		
	}
	
	@Then("^Create Item$")
	public void create_item() {
		
	}
	
	@Then("^Navigate to Requests$")
	public void navigate_to_requests() {
		
	}
	
	@Then("^Create Request$")
	public void create_request() {
		
	}
	
	@Then("^Navigate to All Listed Items$")
	public void navigate_to_all_listed_items() {
		
	}
	
	@Then("^Verify Item is present$")
	public void verify_item_is_present() {
		
	}
	
	@Then("^Modify Profile$")
	public void modify_profile() {
		
	}
	
	@Then("^Logout User One$")
	public void logout_user_one() {
		
	}
	
	@Then("^Register User Two$")
	public void register_user_two() {
		
	}
	
	@Then("^Login User Two$")
	public void login_user_two() {
		
	}
	
	@Then("^Start trade with User One$")
	public void start_trade_with_user_one() {
		
	}
	
	@Then("^Fulfill request for User One$")
	public void fulfill_request_for_user_one() {
		
	}
}
