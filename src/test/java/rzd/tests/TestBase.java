package rzd.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import rzd.components.MainPage;
import rzd.components.RailwayStationPage;
import rzd.components.SearchWidgetComponent;
import rzd.components.VersionForVisuallyImpairedPage;


public class TestBase {
    MainPage mainPage = new MainPage();
    RailwayStationPage railwayStationPage = new RailwayStationPage();
    SearchWidgetComponent searchWidgetComponent = new rzd.components.SearchWidgetComponent();
    VersionForVisuallyImpairedPage versionForVisuallyImpairedPage = new VersionForVisuallyImpairedPage();

    @BeforeAll
    static void setUpConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.rzd.ru";
        Configuration.pageLoadStrategy = "eager";

    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}