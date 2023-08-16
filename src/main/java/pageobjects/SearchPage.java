package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    @AndroidFindBy(id = "com.google.android.apps.maps:id/search_omnibox_edit_text")
    private WebElement searchField;

    @FindBy(xpath = "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout")
    private List<WebElement> searchLocationResults;

    public SearchResultPage searchLocation(String location) {
        waitForClickableElement(searchField, 5);
        searchField.click();
        inputKeys(location);
        searchLocationResults.get(0).click();
        return new SearchResultPage();
    }

    public DirectionsPage searchDirections(String location) {
        waitForClickableElement(searchField, 5);
        searchField.click();
        inputKeys(location);
        searchLocationResults.get(0).click();
        return new DirectionsPage();
    }
}
