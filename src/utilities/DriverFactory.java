package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	// This medthod return a webdriver
	public static WebDriver open(String browserType){
		if (browserType.equalsIgnoreCase("chrome")){
			// code for Chrome
			System.setProperty("webdriver.chrome.driver", "./drivers/windows/chromedriver.exe");
			return new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("ie")){
			// code for IE
			System.setProperty("webdriver.ie.driver", "./drivers/windows/IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else {
			// code for Firefox
			System.setProperty("webdriver.gecko.driver", "./drivers/windows/geckodriver.exe");
			return new FirefoxDriver();	
		}	
	}
}
