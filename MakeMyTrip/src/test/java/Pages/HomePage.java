package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ResuableMethods.CommonMethods;
import Utility.utility;


public class HomePage extends CommonMethods {
	
	@FindBy (xpath = "//a[@class='close']")
	WebElement popUp;
	
	@FindBy (xpath = "//ul//li[@data-cy='oneWayTrip' and @class]")
	WebElement one_way;
	
	@FindBy (xpath = "//span[contains(text(), 'From')]")
	WebElement formCity;
	
	@FindBy (xpath = "//input[contains(@placeholder, 'From')]")
	WebElement formCitySearch;
	
	@FindBy (xpath = "(//p[@class='font14 appendBottom5 blackText']/..)[1]")
	WebElement city;
	
	@FindBy (xpath = "//span[contains(text(), 'To')]")
	WebElement destinationCity;
	
	@FindBy (xpath = "//input[contains(@placeholder, 'To')]")
	WebElement destinationCitySearch;
	
	@FindBy (xpath = "//span[contains(text(), 'Departure')]")
	WebElement Departure;
	
	@FindBy (xpath = "//span[contains(text(), 'Return')]")
	WebElement Return;
	
	String months =  "//div[@class = 'DayPicker-Month']";
	
	String year = "//div[@class = 'DayPicker-Month']//span";
	
	String dates = "//div[@aria-disabled ='false']//div[@class ='dateInnerCell']";
	
	
	@FindBy (xpath = "//span[contains(@aria-label, 'Next Month')]")
	WebElement nextMonthPicker;
	
	@FindBy (xpath = "//span[contains(text(), 'Travellers & Class')]")
	WebElement Travellers;
	
	@FindBy (xpath = "//a[contains(text(), 'Search')]")
	WebElement Search;

	@FindBy (xpath = "//a[contains(text(), 'APPLY')]")
	WebElement apply;
	
	String AdultsCount = "//p[contains(text(), 'ADULTS (12y +)')]//following-sibling::ul//li[contains(@data-cy,'adults')]";
	
	utility util = new utility();
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports reports;
	ExtentTest test1;
	
	
	public void makemytripLandingPage(String url)
	{
		util.OpenBrowser();
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String runtime = sdf.format(d1);
		reporter = new ExtentHtmlReporter(".//Report//flightBooking" +runtime+ ".html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		test1= reports.createTest("flight search");
		driver.get(url);
		test1.info("User enters into makemytrip website" +url);
        //driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		//clicking(homepage.popUp);
 		   
	}
	
	public void ChoosingDdestinationPlacesForTrip(String FromPlace, String ToPlace)
	{
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		if(homepage.one_way.isSelected())
        	{
			test1.info("User gives other details now");
                      
         	}
     	else
        	{
     		clicking(homepage.one_way);
			test1.info("User selectes one way trip");
			
     		}
		
		clicking(homepage.formCity);
		
		test1.info("User clicks on formCity");
		clicking(homepage.formCitySearch);
		test1.info("User chooses formCity search icon");
		passingkeys(homepage.formCitySearch, FromPlace);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test1.info("User provides Form City");
		clicking(homepage.city);
		test1.info("User selects Form City");
		
		clicking(homepage.destinationCity);
		test1.info("User clicks on DestinationCity");
		clicking(homepage.destinationCitySearch);
		test1.info("User chooses DestinationCity search icon");
		passingkeys(homepage.destinationCitySearch, ToPlace);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test1.info("User provides Destination City");
		clicking(homepage.city);
		test1.info("User selects Form City");
		
	}
	
	public void ChoosingDepartureDate_ReturnDate(String DeptDate, String ReturnDate)
	{
		//Departure Flight datemonthYear
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		clicking(homepage.Departure);
		
		test1.info("User clicks on departure to select date");
		
		String Ddate = DeptDate.substring(0, 2);
		for (int i=0;i<getList(homepage.months).size();i++)
		{
			if ((getList(homepage.months).get(i).getText().contains(DeptDate)))
			{
				for (int j=0;j<getList(homepage.year).size();j++)
				{
					if (getList(homepage.year).get(j).getText().contains(DeptDate))
					{
						for(int datecount=0;datecount<getList(homepage.dates).size();datecount++)
						{
							if (getList(homepage.dates).get(datecount).getText().equals(Ddate))
							{
								clicking(getList(homepage.dates).get(datecount));
								test1.info("User selects departure date");
								
							}
						}
					}
					else 
					{
						clicking(homepage.nextMonthPicker);
						test1.info("User click on next for year");
					}
				}
				
				
			}
			else 
			{
				clicking(homepage.nextMonthPicker);
				test1.info("User click on next for month");
			}
		}
	
	// Return Flight DateMonthYear
	
   clicking(homepage.Return);
   
	test1.info("User clicks on return to select date");
	
	String Rdate = DeptDate.substring(0, 2);
	for (int i=0;i<getList(homepage.months).size();i++)
	{
		if ((getList(homepage.months).get(i).getText().contains(DeptDate)))
		{
			for (int j=0;j<getList(homepage.year).size();j++)
			{
				if (getList(homepage.year).get(j).getText().contains(DeptDate))
				{
					for(int datecount=0;datecount<getList(homepage.dates).size();datecount++)
					{
						if (getList(homepage.dates).get(datecount).getText().equals(Ddate))
						{
							clicking(getList(homepage.dates).get(datecount));
							test1.info("User selects return date");
							
						}
					}
				}
				else 
				{
					clicking(homepage.nextMonthPicker);
					test1.info("User click on next for year");
				}
			}
			
			
		}
		else 
		{
			clicking(homepage.nextMonthPicker);
			test1.info("User click on next for month");
		}
	}

   
	}	
	
	public void ChoosingNo_of_travelleresAND_search(String NoOfPassenger) 
	{
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	    clicking(homepage.Travellers);
	    for (int i=0;i<getList(homepage.AdultsCount).size();i++)
	    {
	    	if ((getList(homepage.AdultsCount)).get(i).getText().equals(NoOfPassenger))
	    	{
	    		clicking(getList(homepage.AdultsCount).get(i));
	    		test1.info("User provides no of adults");
				clicking(homepage.apply);
				break;
	    	}
	    	
	    }
	    
	    clicking(homepage.Search);
	    test1.info("User clicks on Search");
	    reports.flush();
	}


}
