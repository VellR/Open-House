package com.platform.open_house.step_definitions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class CreateItemDefinition {
	private WebDriver driver;

	String username = "testtest";
	String password = "test1234";

	@Before
	public void openWindow() {
		/// Users/Student/Downloads/chromedriver_win32/chromedriver.exe
		/// Users/ivell/Downloads/chromedriver_win32/chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "/Users/Student/Downloads/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/open_house/");
	}

	@After
	public void closeWindow() {
		driver.quit();
	}

	@Given("^The Test User is not logged in$")
	public void the_test_user_is_not_logged_in() {
		driver.findElement(By.id("username-input")).sendKeys("testtest");
		driver.findElement(By.id("password-input")).sendKeys("test1234");
		driver.findElement(By.id("password-input")).sendKeys(Keys.ENTER);
	}

	@Then("^Navigate to My Items Page$")
	public void navigate_to_my_items_page() {
		driver.findElement(By.id("items-link")).click();
	}

	@Then("^Click the Add Item button$")
	public void click_the_add_item_button() {
		driver.findElement(By.id("add-item-button")).click();
	}

	@Then("^Enter minimum amount of data for Item$")
	public void enter_minimum_amount_of_data_for_item() {
		String name = randomString(3);

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("description")).sendKeys(randomString(10));

		String price = randomNumber(1, 100) + "." + randomNumber(1, 100);
		driver.findElement(By.id("price")).sendKeys(price);

		String expiration = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
		driver.findElement(By.id("expiration")).sendKeys(expiration);

		driver.findElement(By.id("add-item-button")).click();

		assertThat(driver.findElement(By.id("item-link-" + name)).getText(), is(name));
		driver.findElement(By.id("item-link-" + name)).click();
	}

	@Then("^Enter maximum amount of data for Item$")
	public void enter_maximum_amount_of_data_for_item() {
		String name = randomString(25);

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("description")).sendKeys(randomString(50));

		String price = randomNumber(1, 100) + "." + randomNumber(1, 100);
		driver.findElement(By.id("price")).sendKeys(price);

		String expiration = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
		driver.findElement(By.id("expiration")).sendKeys(expiration);

		driver.findElement(By.id("add-item-button")).click();

		assertThat(driver.findElement(By.id("item-link-" + name)).getText(), is(name));
		driver.findElement(By.id("item-link-" + name)).click();
	}

	@Then("^Enter data for Item without an expiration date$")
	public void enter_data_for_item_without_an_expiration_date() {
		driver.findElement(By.id("name")).sendKeys(randomString(10));
		driver.findElement(By.id("description")).sendKeys(randomString(25));

		String price = randomNumber(1, 100) + "." + randomNumber(1, 100);
		driver.findElement(By.id("price")).sendKeys(price);
	}

	@Then("^Enter data for Item without a price$")
	public void enter_data_for_item_without_a_price() {
		driver.findElement(By.id("name")).sendKeys(randomString(10));
		driver.findElement(By.id("description")).sendKeys(randomString(25));

		String expiration = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
		driver.findElement(By.id("expiration")).sendKeys(expiration);
	}

	@Then("^Enter minimum amount of boundary data for Item$")
	public void enter_minimum_amount_of_boundary_data_for_Item() {
		driver.findElement(By.id("name")).sendKeys(randomString(2));
		driver.findElement(By.id("description")).sendKeys(randomString(9));

		String price = randomNumber(1, 100) + "." + randomNumber(1, 100);
		driver.findElement(By.id("price")).sendKeys(price);

		String expiration = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
		driver.findElement(By.id("expiration")).sendKeys(expiration);
	}

	@Then("^Enter maximum amount of boundary data for Item$")
	public void enter_maximum_amount_of_boundary_data_for_Item() {
		driver.findElement(By.id("name")).sendKeys(randomString(26));
		driver.findElement(By.id("description")).sendKeys(randomString(51));

		String price = randomNumber(1, 100) + "." + randomNumber(1, 100);
		driver.findElement(By.id("price")).sendKeys(price);

		String expiration = randomNumber(1, 13) + randomNumber(1, 30) + randomNumber(1, 2000);
		driver.findElement(By.id("expiration")).sendKeys(expiration);
	}

	@Then("^Verify that all Item errors appear$")
	public void verify_that_all_item_errors_appear() {
		assertThat(driver.findElement(By.id("name.errors")).getText(), containsString("Item must have a name."));
		assertThat(driver.findElement(By.id("description.errors")).getText(),
				containsString("Item must have a description."));
		assertThat(driver.findElement(By.id("price.errors")).getText(),
				containsString("Item must have a price or be 0.00"));
		assertThat(driver.findElement(By.id("expiration.errors")).getText(),
				containsString("Item must have an expiration."));
	}

	@Then("^Verify Item price error appears$")
	public void verify_item_price_error_appears() {
		assertThat(driver.findElement(By.id("price.errors")).getText(),
				containsString("Item must have a price or be 0.00"));
	}

	@Then("^Verify that Item size errors appear$")
	public void verify_that_item_size_errors_appear() {
		assertThat(driver.findElement(By.id("name.errors")).getText(),
				containsString("Item name must be betwen 3 and 25 characters"));
		assertThat(driver.findElement(By.id("description.errors")).getText(),
				containsString("Item description must be between 10 and 50 characters"));
	}

	@Then("^Verify Item expration error appears$")
	public void verify_item_expiration_error_appears() {
		assertThat(driver.findElement(By.id("expiration.errors")).getText(),
				containsString("Item must have an expiration"));
	}

	private String randomString(int length) {
		String output = "";

		for (int i = length; i > 0; i--) {
			String chars = "abcdefghijklmnopqrstuvwxyz";
			Random rnd = new Random();
			char character = chars.charAt(rnd.nextInt(chars.length()));

			output = output + character;
		}

		return output;
	}

	private String randomNumber(int length, int max) {
		String output = "";

		for (int i = length; i > 0; i--) {
			Random random = new Random();
			int randomInt = random.nextInt(max);

			output = output + randomInt;
		}

		return output;
	}
}
