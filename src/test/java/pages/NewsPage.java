package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage {
    private SelenideElement
            result = $(".news-page");

    public NewsPage checkNews(String value) {
        result.shouldHave(text(value));
        return this;
    }
}
