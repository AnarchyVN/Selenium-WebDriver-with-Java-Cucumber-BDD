package tests;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name, email, phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, occassionalEmail;
	WebElement nameElement, emailElement, phoneElement, passwordElement, verifypasswordElement, countryElement, maleRadioElement,
	femaleRadioElement, weeklyCheckbox, monthlyCheckbox, occassionalCheckbox, submitElement;
	WebDriver driver;
	
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + gender
				+ " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occassionalEmail);
		
		defineWebElements();
		
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
		
		
//		submitElement.click();
	}
	
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public void defineWebElements() {
		//Define WebElement
		nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		passwordElement = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
		verifypasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		maleRadioElement = driver.findElement(By.id("MainContent_Male"));
		femaleRadioElement = driver.findElement(By.id("MainContent_Female"));
		weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		occassionalCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		submitElement = driver.findElement(By.id("MainContent_btnSubmit"));
	}
	
	@Parameters
	public static List<String[]> getData(){
		return utilities.CSV.get("./resources/UserAccounts.csv");
		
	}
	
	// Constructor that passes parameters to the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
			String weeklyEmail, String monthlyEmail, String occassionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		
		if (weeklyEmail.equals("TRUE")) { this.weeklyEmail = true; }
		else { this.weeklyEmail = false; }
		
		if (monthlyEmail.equals("TRUE")) { this.monthlyEmail = true; }
		else { this.monthlyEmail = false; }
		
		if (occassionalEmail.equals("TRUE")) { this.occassionalEmail = true; }
		else { this.occassionalEmail = false; }
	}

}
