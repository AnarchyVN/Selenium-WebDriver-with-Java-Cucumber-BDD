package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "chrome";
	String city = "New York, NY";
	String checkIn = "11/06/2019";
	String checkOut = "11/07/2019";
	String childAge = "2";
	
	@Test
	public void hotelReservation() {
//		1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		// traveller selector
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button")).click();

		// adding children traveller

		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div/div[3]/div[1]/div[4]/button")).click();

		// adding child age

		new Select(driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div/div[3]/div[2]/label[1]/select"))).selectByValue(childAge);

		// css selector for search button

		driver.findElement(By.cssSelector("#gcw-hotel-form-hp-hotel div.cols-nested.ab25184-submit label button")).click();
		
		
//		2. Modify the search results, give criteria
		
//		3. Analyze the results and make our selection
		
//		4. Book reservation
		
//		5.Fill out contact / billing
		
//		6. Get confirmation
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType, System.getProperty("os.name").toLowerCase());
		driver.get("http://www.expedia.com/");
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
