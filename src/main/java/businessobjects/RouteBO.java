package businessobjects;

import io.qameta.allure.Step;
import pageobjects.LoginPage;
import pageobjects.SearchResultPage;

public class RouteBO {
    @Step("Search location - {0}")
    public RouteBO searchLocation(String location) {
        new LoginPage().skipLogin().goToSearch().searchLocation(location);
        return this;
    }

    @Step("Get route to destination - {0}")
    public RouteBO getRouteToDestination(String destination) {
        new SearchResultPage().goToLocation().getDirections().getDirectionsToDestination(destination);
        return this;
    }

    @Step("Find attraction - {0}")
    public RouteBO findAttraction(String attraction) {
        new SearchResultPage().seeNearbyAttractions().swipeToLocation(attraction);
        return this;
    }
}
