package StepDef;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Steps {


	HomePage homepage = new HomePage();

	@Given("User is on makemytrip landing page by hitting the url {string}")
	public void makemytripLandingPageStep(String url) throws Throwable {
		homepage.makemytripLandingPage(url);
	}


	@Given("User chooses start {string} & destination {string}  places for trip")
	public void ChoosingDdestinationPlacesForTripStep(String FromPlace, String ToPlace) throws Throwable {
		homepage.ChoosingDdestinationPlacesForTrip(FromPlace, ToPlace);
	}


	@When("User provides departure date {string} and return date {string}")
	public void ChoosingDepartureDate_ReturnDateStep(String DeptDate, String ReturnDate) throws Throwable {
		homepage.ChoosingDepartureDate_ReturnDate(DeptDate, ReturnDate);
	}


	@When("User chooses no of travelleres {string} and click on search button")

	public void ChoosingNo_of_travelleresAND_searchStep(String NoOfPassenger) throws Throwable {
		homepage.ChoosingNo_of_travelleresAND_search(NoOfPassenger);
	}
}
/*
		private WebDriver driver;
		private FlightBookingPage flightBookingPage;

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


		@Given("User is on makemytrip landing page by hitting the url {string}")
		public void userIsOnMakemytripLandingPage(String makemytripUrl) {
			driver.get(makemytripUrl);
			flightBookingPage = new FlightBookingPage(driver);
		}

		@Given("User chooses start {string} and destination {string}  places for trip")
		public void userChoosesStartAndDestinationPlaces(String from, String to) {
			flightBookingPage.selectStartPlace(from);
			flightBookingPage.selectDestinationPlace(to);
		}

		@When("User provides departure date {string} and return date {string}")
		public void userProvidesDepartureAndReturnDates(String departureDate, String returnDate) {
			flightBookingPage.selectDepartureDate(departureDate);
			flightBookingPage.selectReturnDate(returnDate);
		}

		@When("User chooses no of travelleres {string} and click on search button")
		public void userChoosesNumberOfTravellersAndClickOnSearch(int numberOfTravellers) {
			flightBookingPage.selectNumberOfTravellers(numberOfTravellers);
			flightBookingPage.clickSearchButton();
		}
	}*/

