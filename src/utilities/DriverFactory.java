package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	// This medthod return a webdriver
	public static WebDriver open(String browserType, String osType){
		if (osType.contains("mac")) {	
			if (browserType.equalsIgnoreCase("chrome")){
				// code for Chrome
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/mac/chromedriver");
				return new ChromeDriver();
			}
			else {
				// code for Firefox
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/mac/geckodriver");
				return new FirefoxDriver();	
			}	
		}
		else
		{
			if (browserType.equalsIgnoreCase("chrome")){
				// code for Chrome
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\windows\\chromedriver.exe");
				return new ChromeDriver();
			}
			else if (browserType.equalsIgnoreCase("ie")){
				// code for IE
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\windows\\IEDriverServer.exe");
				return new InternetExplorerDriver();
			}
			else {
				// code for Firefox
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\windows\\geckodriver.exe");
				return new FirefoxDriver();	
			}
		}
	}
}
