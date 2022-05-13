package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AllureAttachments;
import helpers.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;
import pages.NewsPage;
import pages.RuRegistryPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    RuRegistryPage ruRegistryPage = new RuRegistryPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverConfig.configure();
    }

    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs("Скриншот");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        closeWebDriver();
    }
}
