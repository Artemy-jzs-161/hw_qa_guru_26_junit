package rzd.components;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;

public class VersionForVisuallyImpairedPage {

    public VersionForVisuallyImpairedPage setColor(String colorName) {
        $("[aria-label='" + colorName + "']").click();
        return this;
    }

    public VersionForVisuallyImpairedPage setSize(String sizeName) {
        $("[aria-label='" + sizeName + "']").click();
        return this;
    }

    public VersionForVisuallyImpairedPage checkSize(String sizePixel) {
        $("#direction-from").shouldHave(cssValue("font-size", sizePixel));
        return this;
    }

    public VersionForVisuallyImpairedPage checkColor(String colorNumber) {
        $("#direction-from").shouldHave(cssValue("background-color", colorNumber));
        return this;
    }
}