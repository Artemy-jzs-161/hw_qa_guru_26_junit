package rzd.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RZDTests extends TestBase {

    @ValueSource(strings = {
            "Новосибирск", "Омск"
    })
    @ParameterizedTest(name = "Проверка поиска вокзала {0}")
    @Tags({
            @Tag("REGRESS"),
            @Tag("WEB")
    })
    void searchRailwayStationTest(String searchQuery) {
        mainPage.openPage();
        railwayStationPage.selectMenu();
        railwayStationPage.setLocation(searchQuery);

        railwayStationPage.checkingRailwayStation();
    }

    @CsvFileSource(resources = "/infoForBuyTickets.csv")
    @ParameterizedTest(name = "Проверка поиска билета на поезд")
    @Tags({
            @Tag("REGRESS"),
            @Tag("WEB")
    })
    void checkBuyTicket(String locationFrom, String locationTo,
                        String dateFrom, String dateTo) {
        mainPage.openPage();
        searchWidgetComponent.selectLocationFrom(locationFrom);
        searchWidgetComponent.selectLocationTo(locationTo);
        searchWidgetComponent.selectDateFrom(dateFrom);
        searchWidgetComponent.selectDateTo(dateTo);
        searchWidgetComponent.buttonSearch();

        searchWidgetComponent.checkSearchResult();
    }

    @ParameterizedTest(name = "Проверка отображаются на экране цвета {0} и размера текста {1}")
    @Tags({
            @Tag("REGRESS"),
            @Tag("SMOKE")
    })
    @CsvSource(value = {
            "Черный | Средний | rgba(0, 0, 0, 1)       | 20px",
            "Синий  | Мелкий  | rgba(104, 192, 255, 1) | 16px",
            "Белый  | Большой | rgba(255, 255, 255, 1) | 22px"
    }, delimiter = '|')
    void checkFontAndColorTest(String colorName, String sizeName, String colorNumber, String sizePixel) {
        mainPage.openPage();
        mainPage.openPageForVisuallyImpaired();
        versionForVisuallyImpairedPage.setColor(colorName);
        versionForVisuallyImpairedPage.setSize(sizeName);

        versionForVisuallyImpairedPage.checkColor(colorNumber);
        versionForVisuallyImpairedPage.checkSize(sizePixel);
    }


}
