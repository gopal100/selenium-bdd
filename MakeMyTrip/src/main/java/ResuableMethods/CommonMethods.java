package ResuableMethods;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.utility;

public class CommonMethods extends utility{
	
	public void clicking(WebElement e)
	{
		e.click();
	}

	public void passingkeys(WebElement e, String text)
	{
		e.sendKeys(text);
	}
	
	public List<WebElement> getList(String xpath)
	{
		return driver.findElements(By.xpath(xpath));
		
	}

	public void alertHandle()
	{
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	public void waittime(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void switchWindows()
	{
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		for (String child:windows)
		{
			if (!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.close();
			}
		}
	}

}
