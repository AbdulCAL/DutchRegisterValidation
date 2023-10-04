package com.dutch.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PetInfoAddValidation {

	/*
	 * Test Registration Pet Info form
	 * 
	 * URL: https://www.dutch.com/
	 * 
	 */

	// Kerim Test Case Dutch Task V01
	// Open firefox browser Go to "https://www.dutch.com/"
	// Click on Join Now
	// Fill out ALL required info:
	// Pet Type (radioButton), Pet"s Name(TextBox),Pet's Home State(Select Dropdown)
	// Click Continue
	// Issues Page; Choose Itching (Xpath ID)
	// Click Continue
	// User Info Page: Email and Password
	// validate pet info added before pet's human friend info page

	public final static String url = "https://www.dutch.com/";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get(url);
		Thread.sleep(2000);

		// continue
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/a")).click();
		Thread.sleep(2000);

		// Pet Info Page

		// Pet"s Name(TextBox)
		driver.findElement(By.xpath("//*[@id=\"pet-name\"]")).sendKeys("Pet1Dog");
		Thread.sleep(1000);

		// Pet Type (radioButton)
		driver.findElement(By.xpath("//*[@id=\"dog\"]")).click();
		Thread.sleep(1000);

		// Pet's Home State(Select Dropdown)
		Select sel = new Select(driver.findElement(By.id("state")));
		sel.selectByValue("AL");
		Thread.sleep(1000);

		// Continue button
		driver.findElement(By.xpath("/html/body/main/div/div/div/div/form/div[3]/button")).click();
		Thread.sleep(2000);

		// Issues Page
		// Choose Itching
		driver.findElement(By.xpath("/html/body/main/div/div/div/div/form/ul/li[13]/label/p")).click();
		Thread.sleep(1000);
		// Continue button
		driver.findElement(By.xpath("/html/body/main/div/div/div/div/form/div/button")).click();
		Thread.sleep(2000);

		// Expected text on User Info Page
		String expectedText = "EMAIL";
		String actualText = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div/form[1]/div[1]/label"))
				.getText();

		if (expectedText.equals(actualText)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}

		driver.quit();

	}

}
