import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    // Initialize driver, but don't instantiate in this class.
    WebDriver driver;

    // Method used to verify the existence of elements
    // to verify we're on the right page.
    public void BasePageObject(By element) {
        try {
            driver.findElement(element);
        } catch (NoSuchElementException e) {
            throw new WrongPageException("Could not find element: " + element + ". Is this the right page?");
        }
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public void deleteText(By element) {
        driver.findElement(element).sendKeys(Keys.COMMAND + "a");
        driver.findElement(element).sendKeys(Keys.DELETE);
    }

    public void enterText(By element, String textEntry) {
        driver.findElement(element).click();
        driver.findElement(element).sendKeys(textEntry);
    }

    public void waitUntilVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
