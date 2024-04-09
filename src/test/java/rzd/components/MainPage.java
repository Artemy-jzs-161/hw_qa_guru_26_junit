package rzd.components;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
            clickCheckLanguage = $(".icon-locale"),
            buttonVersionForVisuallyImpaired = $(".blind__text");

    public MainPage openPageForVisuallyImpaired() {
        buttonVersionForVisuallyImpaired.click();
        return this;
    }

    public MainPage openPage() {
        open("/");
        return this;
    }
}
