package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.parser.ValueParser;

public class DirectionsPage extends BasePage {
    @AndroidFindBy(accessibility = "Swap start and destination")
    private WebElement swapRoutesButton;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/directions_startpoint_textbox")
    private WebElement startingPointField;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private WebElement durationLabel;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private WebElement distanceLabel;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
    private WebElement validationMessage;

    public DirectionsPage getDirectionsToDestination(String destination) {
        SearchPage searchPage = searchPoint(startingPointField);
        searchPage.searchDirections(destination);
        swapRoutesButton.click();
        return new DirectionsPage();
    }

    public SearchPage searchPoint(WebElement location) {
        location.click();
        return new SearchPage();
    }

    public boolean isRouteImpossible() {
        return isElementVisible(validationMessage, 5);
    }

    public boolean isRouteFound() {
        return isElementVisible(durationLabel, 5);
    }

    public boolean isRouteEfficient(String durationLimit, String distanceLimit) {
        if (isRouteFound()) {
            int expDuration = ValueParser.parseDuration(durationLimit);
            double expDistance = ValueParser.parseDistance(distanceLimit);

            int actualDuration = ValueParser.parseDuration(durationLabel.getText());
            double actualDistance = ValueParser.parseDistance(distanceLabel.getText());

            return actualDuration <= expDuration && actualDistance <= expDistance;
        }
        return false;
    }

    public String getValidationMessage() {
        if (isRouteImpossible()) {
            return validationMessage.getText();
        }
        return "A route was found";
    }

}
