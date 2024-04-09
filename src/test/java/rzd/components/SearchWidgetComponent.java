package rzd.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchWidgetComponent {

    private final SelenideElement
            locationFromElement = $("#direction-from"),
            locationToElement = $("#direction-to"),
            confirmationSelectionElement = $(".rzd-suggestion--usual-icon", 1),
            dateFromElemet = $("#datepicker-from"),
            dateToElement = $("#datepicker-to"),
            buttonSearchElement = $(".rzd-button"),
            resultsWrap = $(".results-wrap");

    public SearchWidgetComponent selectLocationFrom(String locationFrom) {
        locationFromElement.setValue(locationFrom);
        confirmationSelectionElement.click();
        return this;
    }

    public SearchWidgetComponent selectLocationTo(String To) {
        locationToElement.setValue(To);
        confirmationSelectionElement.click();
        return this;
    }

    public SearchWidgetComponent selectDateFrom(String dateFrom) {
        dateFromElemet.setValue(dateFrom).pressTab();
        return this;
    }

    public SearchWidgetComponent selectDateTo(String dateTo) {
        dateToElement.setValue(dateTo).pressTab();
        return this;
    }

    public SearchWidgetComponent buttonSearch() {
        buttonSearchElement.click();
        return this;
    }

    public SearchWidgetComponent checkSearchResult() {
        resultsWrap.shouldBe(visible);

        return this;
    }
}
