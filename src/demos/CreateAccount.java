package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// 1. Open the web browser
		System.setProperty("webdriver.gecko.driver", "./drivers/windows/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
				
		// 2. Navigate to Account Management page >> Click on Create Account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		
		// 3. Fill out the form
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Huy Hoang");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("hh@testemail.com");
		driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("123456789");
		driver.findElement(By.cssSelector("#MainContent_txtPassword")).sendKeys("hhpass");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("hhpass");
		
		//How to interact with other elements
		driver.findElement(By.id("MainContent_Male")).click();
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Germany");
		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		// 4. Get confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")) .getText();
		System.out.println("CONFIRMATION: " + conf);
		
		// 5. Close the browser
		driver.close();
	}

}
