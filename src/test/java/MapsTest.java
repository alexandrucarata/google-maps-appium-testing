import businessobjects.RouteBO;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.filereader.ConfigFileReader;
import verifiers.RouteVerifier;

@Epic("Maps Tests")
public class MapsTest extends BaseTest {
    private final RouteVerifier routeVerifier = new RouteVerifier();
    private final String startingLocation = ConfigFileReader.getProperty("starting.location");
    private final String endingLocation = ConfigFileReader.getProperty("ending.location");
    private final String impossibleLocation = ConfigFileReader.getProperty("impossible.location");
    private final String durationLimit = ConfigFileReader.getProperty("duration.limit");
    private final String distanceLimit = ConfigFileReader.getProperty("distance.limit");
    private final String landmarkLocation = ConfigFileReader.getProperty("landmark.location");
    private final String attractionTitle = ConfigFileReader.getProperty("attraction.title");
    private final String attractionAddress = ConfigFileReader.getProperty("attraction.address");

    @Story("Route Planning")
    @Feature("Ability to plan route")
    @Description("Check if efficient route can be planned")
    @Test(description = "Find Efficient Route Test")
    public void findEfficientRouteTest() {
        new RouteBO().searchLocation(startingLocation).getRouteToDestination(endingLocation);

        SoftAssert softAssert = new SoftAssert();
        routeVerifier.verifyRouteIsFound(softAssert);
        routeVerifier.verifyRouteIsEfficient(durationLimit, distanceLimit, softAssert);
        softAssert.assertAll();
    }

    @Story("Route Planning")
    @Feature("Inability to plan impossible route")
    @Description("Check if route cannot be planned when it is impossible")
    @Test(description = "Find Impossible Route Test")
    public void findImpossibleRouteTest() {
        new RouteBO().searchLocation(startingLocation).getRouteToDestination(impossibleLocation);

        SoftAssert softAssert = new SoftAssert();
        routeVerifier.verifyRouteIsNotFound(softAssert);
        routeVerifier.verifyNotFoundValidation(softAssert);
        softAssert.assertAll();
    }

    @Story("Attraction Finding")
    @Feature("Ability to find nearby attractions")
    @Description("Check nearby attractions can be found and accessed from preview")
    @Test(description = "Find Location Attraction Test")
    public void findLocationAttractionTest() {
        new RouteBO().searchLocation(landmarkLocation).findAttraction(attractionTitle);

        SoftAssert softAssert = new SoftAssert();
        routeVerifier.verifyTitleMatches(attractionTitle, softAssert);
        routeVerifier.verifyAddressMatches(attractionAddress, softAssert);
        softAssert.assertAll();
    }
}
