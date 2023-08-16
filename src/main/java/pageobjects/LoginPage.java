package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "(//android.widget.Button)[1]")
    WebElement skipButton;

    public HomePage skipLogin() {
        if (skipButton.getText().equals("SKIP")) {
            skipButton.click();
        }
        return new HomePage();
    }
}

