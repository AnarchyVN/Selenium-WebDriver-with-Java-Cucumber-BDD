package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ATagsTest {
	WebDriver driver;
  @Test
  public void loginElementsPresentTest() {
	  System.out.println("Running test");
	  boolean createAccountPresent = false;
	  
//	  We want to test the presence of A tags >> hyperlink
	  List <WebElement> aElements = driver.findElements(By.tagName("a"));
	  
	  int numberOfAElements = aElements.size();
	  System.out.println("There are " + numberOfAElements + " a tags on the page");
	 
	  for (WebElement aElement : aElements) {
		  System.out.println(aElement.getText());
		  if(aElement.getText().equals("CREATE ACCOUNT")) {
			  createAccountPresent = true;
			  break;
		  }
	  }
//	  Assertion
	  Assert.assertTrue(createAccountPresent);
  }
  
  @BeforeMethod
	public void setUp() {
		System.out.println("Stating test");
		String WeURl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		
		driver = utilities.DriverFactory.open("chrome", System.getProperty("os.name").toLowerCase());
		driver.get(WeURl);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing test");
		driver.close();
	}
}
