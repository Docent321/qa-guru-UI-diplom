package tests;

import org.junit.jupiter.api.Test;
import pages.RuRegistryPage;
import testData.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testData.TestData.*;

public class RaoTest {

    RuRegistryPage ruRegistryPage = new RuRegistryPage();
    TestData testData = new TestData();
/*
    String
            work = "ШТИЛЬ",
            work1 = "15 лет",
            author = "Дубинин",
            value = "ШТИЛЬ",
            author1 = "КИПЕЛОВ ВАЛЕРИЙ АЛЕКСАНДРОВИЧ";
*/

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
        ruRegistryPage.openPage()
                .setWork(work)
                .setAuthor(author)
                .submitClick()
                .checkForm(value);
    }

    @Test
    void russianRegistrySearchWorkTest(){
        ruRegistryPage.openPage()
                .setWork(work1)
                .submitClick()
                .checkForm(work1);
    }

    @Test
    void russianRegistrySearchAuthorTest(){
        ruRegistryPage.openPage()
                .setAuthor(author1)
                .submitClick()
                .checkForm(author1);
    }
}
