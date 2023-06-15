package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class utility {
		
		public static WebDriver driver;
		
		@Before
		public void OpenBrowser()
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ".//Chrome//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}

		@After
		public void CloseBrowser()
		{
			driver.quit();
		}
	}



