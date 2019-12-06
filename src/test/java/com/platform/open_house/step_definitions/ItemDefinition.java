package com.platform.open_house.step_definitions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.platform.open_house.models.Item;

import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class ItemDefinition {
	private WebDriver driver;
	Item itemModel = new Item("Create Test Item", "This is the create test item description", 32.42, "2019-12-06");

	@AfterClass
	public void breakdown() {
		driver.close();
	}
	
	@Then("^login User$")
	public void login_user() {
	    driver.findElement(By.id("usernameInput")).sendKeys("test");
	    driver.findElement(By.id("passwordInput")).sendKeys("test");
	    
	    driver.findElement(By.cssSelector(".btn-black")).click();
	}
	
	@Then("^navigate to Item Page$")
	public void navigate_to_item_page() {
		driver.findElement(By.linkText("My Items")).click();
	}
	
	@Then("^create a new item$")
	public void create_a_new_item() {
		driver.findElement(By.id("name")).sendKeys(itemModel.getName());
	    driver.findElement(By.id("description")).sendKeys(itemModel.getDescription());
	    driver.findElement(By.id("price")).sendKeys(itemModel.getPrice().toString());
	    driver.findElement(By.id("expiration")).sendKeys(itemModel.getExpiration());
	    
	    driver.findElement(By.cssSelector(".btn")).click();
	}
	
	@Then("^verfiy that the item has been created$")
	public void verify_that_the_item_has_been_created() {
		assertThat(driver.findElement(By.cssSelector(".card-title")).getText(), is(itemModel.getName()));
		assertThat(driver.findElement(By.cssSelector("h4")).getText(), is(itemModel.getPrice()));
		assertThat(driver.findElement(By.cssSelector(".card-text")).getText(), is(itemModel.getDescription()));
	}
}
