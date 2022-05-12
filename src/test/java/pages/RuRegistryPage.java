package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RuRegistryPage{

    private SelenideElement
            titlePage = $(".col-md-12"),
            setWork = $("[name=work]"),
            setAuthor = $("[name=author]"),
            submitClick = $(".search-reestr"),
            results = $(".search-result-reestr");


    public RuRegistryPage openPage() {
        open("https://rao.ru/information/reestry/reestr-proizvedenij-rossijskih-pravoobladatelej/");
        titlePage.shouldHave(text("Реестр произведений российских правообладателей"));
        return this;
    }

    public RuRegistryPage setWork(String work) {
        setWork.setValue(work);
        return this;
    }

    public RuRegistryPage setAuthor(String author) {
        setAuthor.setValue(author);
        return this;
    }

    public RuRegistryPage submitClick() {
        submitClick.click();
        return this;
    }

    public RuRegistryPage checkForm(String value) {
        results.shouldHave(text(value));
        return this;
    }

}
