import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class FlightListPage extends BasePageObject {
    private static final By FLIGHT_LIST = (By.id("flight-listing-container"));
    private static final By NO_FLIGHTS = (By.id("ajax-error"));


    // Makes sure this class uses the driver already instantiated, rather than
    // instantiating a new one
    public FlightListPage(WebDriver driver) {
        this.driver = driver;
        super.BasePageObject(FLIGHT_LIST);
    }

    public void waitForFlightList() {
        this.waitUntilVisible(FLIGHT_LIST);
    }


    public void verifyFlightsExist() {

        // Forces the code to wait to see if the "NO_FLIGHTS" error comes up.
        // If it doesn't come up because there are flights, this unfortunately
        // means the code is just paused for 50 seconds.
        try {
            this.waitUntilVisible(NO_FLIGHTS);
        } catch (TimeoutException expected) {

        }

        if (this.findElement(NO_FLIGHTS).isDisplayed()) {
            System.out.println("Couldn't find any flights. :(");
        } else if (this.findElement(FLIGHT_LIST).isDisplayed()){
            System.out.println("Flights exist!");
        }
    }
}

