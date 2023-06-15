package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingPage {
    private WebDriver driver;

    // Locators for web elements on the flight booking page
    private By startPlaceDropdown = By.id("fromCity");
    private By destinationPlaceDropdown = By.id("toCity");
    private By departureDateInput = By.id("departure");
    private By returnDateInput = By.id("return");
    private By numberOfTravellersDropdown = By.id("travellers");
    private By searchButton = By.xpath("//a[contains(@class, 'primaryBtn')]");

    public FlightBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectStartPlace(String startPlace) {
        WebElement startPlaceDropdownElement = driver.findElement(startPlaceDropdown);
        startPlaceDropdownElement.sendKeys(startPlace);
    }

    public void selectDestinationPlace(String destinationPlace) {
        WebElement destinationPlaceDropdownElement = driver.findElement(destinationPlaceDropdown);
        destinationPlaceDropdownElement.sendKeys(destinationPlace);
    }

    public void selectDepartureDate(String departureDate) {
        WebElement departureDateInputElement = driver.findElement(departureDateInput);
        departureDateInputElement.sendKeys(departureDate);
    }

    public void selectReturnDate(String returnDate) {
        WebElement returnDateInputElement = driver.findElement(returnDateInput);
        returnDateInputElement.sendKeys(returnDate);
    }

    public void selectNumberOfTravellers(int numberOfTravellers) {
        WebElement numberOfTravellersDropdownElement = driver.findElement(numberOfTravellersDropdown);
        Select numberOfTravellersDropdownSelect = new Select(numberOfTravellersDropdownElement);
        numberOfTravellersDropdownSelect.selectByVisibleText(String.valueOf(numberOfTravellers));
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
    }
}
