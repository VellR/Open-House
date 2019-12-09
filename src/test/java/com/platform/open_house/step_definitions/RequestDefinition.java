package com.platform.open_house.step_definitions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.platform.open_house.models.Request;

import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class RequestDefinition {
	private WebDriver driver;
	private Request modelRequest= new Request("Test Request", "Test Request Description", "1.11", true, "Test Barter Item");
	
	@AfterClass
	public void breakdown() {
		driver.close();
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
