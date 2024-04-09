package rzd.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RailwayStationPage {

    private final ElementsCollection
            railwayStationElement = $$(".header_actions-item__link");

    private final SelenideElement
            locationElement = $("input[name='keywords']"),
            tableElement = $(".table2__body");

    public RailwayStationPage selectMenu() {
        railwayStationElement.findBy(text("Вокзалы")).click();
        return this;
    }

    public RailwayStationPage setLocation(String searchQuery) {
        locationElement.setValue(searchQuery).pressEnter();
        return this;
    }

    public RailwayStationPage checkingRailwayStation() {
        tableElement.shouldBe(visible);
        return this;
    }
}
