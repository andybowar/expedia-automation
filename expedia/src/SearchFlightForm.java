import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchFlightForm extends BasePageObject {
    private static final String BASE_URL = "https://www.expedia.com";
    private static final By FLIGHTS = (By.id("tab-flight-tab-hp"));
    private static final By FLYING_FROM_EL = (By.id("flight-origin-hp-flight"));
    private static final String FLYING_FROM = "MSP";
    private static final By FLYING_TO_EL = (By.id("flight-destination-hp-flight"));
    private static final String FLYING_TO = "KEF";
    private static final By DEPARTING = (By.id("flight-departing-hp-flight"));
    private static final By RETURNING = (By.id("flight-returning-hp-flight"));
    private static final String DEP_DATE = "05/16/18";
    private static final String RET_DATE = "05/26/18";
    private static final By SEARCH = (By.cssSelector("button.btn-primary.btn-action.gcw-submit"));

    // Method used to both navigate to starting page and verify we've navigated
    // to the correct page.
    public void verifyPage() {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
        super.BasePageObject(FLIGHTS);
    }

    public void waitForFlightElement() {
        this.waitUntilVisible(FLIGHTS);
    }

    public void clickFlights() {
        this.findElement(FLIGHTS).click();
    }

    public void enterOrigin() {
        this.enterText(FLYING_FROM_EL, FLYING_FROM);
    }

    public void enterDest() {
        this.enterText(FLYING_TO_EL, FLYING_TO);
    }

    // Ideally, we would click a date, rather than hard-code a date to be typed in
    public void departureDate() {
        this.enterText(DEPARTING, DEP_DATE);
    }

    // Ideally, we would click a date, rather than hard-code a date to be typed in
    public void arrivalDate() {
        this.deleteText(RETURNING);
        this.enterText(RETURNING, RET_DATE);
    }

    public FlightListPage submitSearch() {
        this.findElement(SEARCH).click();
        return new FlightListPage(driver);
    }

}
