package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPage extends BasePage {
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.Button")
    private WebElement directionsButton;

    @FindBy(xpath = "//android.widget.ViewSwitcher/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement locationTitle;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    private WebElement addressLabel;

    public DirectionsPage getDirections() {
        directionsButton.click();
        return new DirectionsPage();
    }

    public String getTitle() {
        return locationTitle.getText();
    }

    public String getAddress() {
        return addressLabel.getText();
    }
}
