package pageobjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.drivermanager.DriverManager;

import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;

    public BasePage() {
        this.driver = DriverManager.getInstance();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void waitForClickableElement(WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void inputKeys(String keys) {
        Actions action = new Actions(driver);
        action.sendKeys(keys).perform();
    }

    public boolean isElementVisible(WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void swipe(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript(
                "mobile: swipeGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "direction", direction,
                        "percent", 0.75
                )
        );
    }
}
