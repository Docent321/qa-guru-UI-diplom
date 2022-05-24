package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MainPage {

    private SelenideElement
            result = $(".logo-section"),
            submitnews = $(".menu-item-4955");

    public MainPage openPage() {
        open("baseURL");
        return this;
    }

    public MainPage checkForm(String value) {
        result.shouldHave(text(value));
        return this;
    }

    public MainPage submitNews() {
        submitnews.click();
        return this;
    }
}
