package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    @AndroidFindBy(id = "com.google.android.apps.maps:id/title")
    private WebElement locationResult;

    @FindBy(xpath = "//androidx.viewpager.widget.ViewPager/android.widget.FrameLayout")
    private List<WebElement> resultsList;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/on_map_refresh_action_container")
    private WebElement seeNearbyAttractionsButton;

    public LocationPage goToLocation() {
        locationResult.click();
        return new LocationPage();
    }

    public LocationPage swipeToLocation(String location) {
        if (resultsList.get(0).getAttribute("content-desc").contains(location)) {
            resultsList.get(0).click();
            return new LocationPage();
        }
        swipe(resultsList.get(0), "left");
        while (!resultsList.get(1).getAttribute("content-desc").contains(location)) {
            swipe(resultsList.get(1), "left");
        }
        resultsList.get(1).click();
        return new LocationPage();
    }

    public SearchResultPage seeNearbyAttractions() {
        waitForClickableElement(seeNearbyAttractionsButton, 5);
        seeNearbyAttractionsButton.click();
        return new SearchResultPage();
    }
}
