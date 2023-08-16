package pageobjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    @AndroidFindBy(id = "com.google.android.apps.maps:id/search_omnibox_text_box")
    private WebElement searchField;

    public SearchPage goToSearch() {
        waitForClickableElement(searchField, 5);
        searchField.click();
        return new SearchPage();
    }
}
