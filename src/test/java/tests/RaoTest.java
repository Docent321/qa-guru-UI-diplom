package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RaoTest {

    @Test
    void homePageTest(){
        open("https://rao.ru/");
        $(".logo-section").shouldHave(text("РОССИЙСКОЕ АВТОРСКОЕ ОБЩЕСТВО"));
    }

    @Test
    void newsRaoTest(){
        open("https://rao.ru/");
        $("#menu-item-4955").click();
        $(".news-page").shouldHave(text("НОВОСТИ"));
    }

    @Test
    void russianRegistrySearchWorkAuthorTest(){
        open("https://rao.ru/information/reestry/reestr-proizvedenij-rossijskih-pravoobladatelej/");
        $("[name=work]").setValue("ШТИЛЬ");
        $("[name=author]").setValue("Дубинин");
        $(".search-reestr").click();
        $(".search-result-reestr").shouldHave(text("ШТИЛЬ"));
    }

    @Test
    void russianRegistrySearchWorkTest(){
        open("https://rao.ru/information/reestry/reestr-proizvedenij-rossijskih-pravoobladatelej/");
        $("[name=work]").setValue("15 лет");
        $(".search-reestr").click();
        $(".search-result-reestr").shouldHave(text("15 лет"));
    }

    @Test
    void russianRegistrySearchAuthorTest(){
        open("https://rao.ru/information/reestry/reestr-proizvedenij-rossijskih-pravoobladatelej/");
        $("[name=author]").setValue("КИПЕЛОВ ВАЛЕРИЙ АЛЕКСАНДРОВИЧ");
        $(".search-reestr").click();
        $(".search-result-reestr").shouldHave(text("ВОЗЬМИ МОЕ СЕРДЦЕ"));
    }
}
