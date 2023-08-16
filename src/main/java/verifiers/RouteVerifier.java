package verifiers;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pageobjects.DirectionsPage;
import pageobjects.LocationPage;
import utils.filereader.ConfigFileReader;

public class RouteVerifier {
    @Step("Verify route is found")
    public void verifyRouteIsFound(SoftAssert softAssert) {
        boolean found = new DirectionsPage().isRouteFound();
        softAssert.assertTrue(found);
    }

    @Step("Verify route is efficient")
    public void verifyRouteIsEfficient(String durationLimit, String distanceLimit, SoftAssert softAssert) {
        boolean efficient = new DirectionsPage().isRouteEfficient(durationLimit, distanceLimit);
        softAssert.assertTrue(efficient);
    }

    @Step("Verify route is not found")
    public void verifyRouteIsNotFound(SoftAssert softAssert) {
        boolean found = new DirectionsPage().isRouteImpossible();
        softAssert.assertTrue(found);
    }

    @Step("Verify route not found validation is displayed")
    public void verifyNotFoundValidation(SoftAssert softAssert) {
        String message = new DirectionsPage().getValidationMessage();
        softAssert.assertEquals(message, ConfigFileReader.getProperty("not.found.validation"));
    }

    @Step("Verify title matches - {0}")
    public void verifyTitleMatches(String title, SoftAssert softAssert) {
        String actualTitle = new LocationPage().getTitle();
        softAssert.assertEquals(actualTitle, title);
    }

    @Step("Verify address matches - {0}")
    public void verifyAddressMatches(String address, SoftAssert softAssert) {
        String actualAddress = new LocationPage().getAddress();
        softAssert.assertEquals(actualAddress, address);
    }
}
