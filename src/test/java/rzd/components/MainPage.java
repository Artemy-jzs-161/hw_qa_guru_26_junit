package rzd.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
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
