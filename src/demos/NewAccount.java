package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String browserType = "chrome";
		String osType = System.getProperty("os.name").toLowerCase();
		String name = "Huy Hoang";
		String email = "hh@testemail.com";
		String phone = "123456789";
		String password = "hhpass";
		String country = "Germany";
		String gender = "Female";
		boolean weeklyEmail = false;
		boolean monthlyEmail = false;
		boolean occassionalEmail = false;
		
		//Define Webdriver
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType, osType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		
		//Define WebElement
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordElement = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
		WebElement verifypasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadioElement = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleRadioElement = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement occassionalCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement submitElement = driver.findElement(By.id("MainContent_btnSubmit"));
		
		// 3. Fill out the form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
		passwordElement.sendKeys(password);
		verifypasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		//Gender radio button algorithm
		if (gender.equalsIgnoreCase("Male")) {
			maleRadioElement.click();
		}
		else {
			femaleRadioElement.click();
		}
		
		//Check box algorithm
		if (weeklyEmail) {
			if (!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		else {
			if (weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		
		if (monthlyEmail) {
			if (!monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
		}
		else {
			if (monthlyCheckbox.isSelected()) {
				monthlyCheckbox.click();
			}
		}
		
		if (occassionalEmail) {
			if (!occassionalCheckbox.isSelected()) {
				occassionalCheckbox.click();
			}
		}
		else {
			if (occassionalCheckbox.isSelected()) {
				occassionalCheckbox.click();
			}
		}
		
		
		submitElement.click();
		
		// 4. Get confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.equals(expected)) {
			System.out.println("CONFIRMATION: " + conf);
		}
		else {
			System.out.println("TEST FAILED");
		}
		
		// 5. Close the browser
		driver.close();
	}
}
