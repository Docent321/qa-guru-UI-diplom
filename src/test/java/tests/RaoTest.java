package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NewsPage;
import pages.RuRegistryPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static testData.TestData.*;

public class RaoTest extends TestBase{

    RuRegistryPage ruRegistryPage = new RuRegistryPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();

    @DisplayName("Главная страница")
    @Test
    void homePagePOTest(){
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Проверить наличие надписи РОССИЙСКОЕ АВТОРСКОЕ ОБЩЕСТВО в хедере", () -> {
            mainPage.checkRao(logo);
        });
    }

    @DisplayName("Переход в раздел Новости")
    @Test
    void newsRaoTest(){
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        sleep(5000);
        step("Нажать на кнопку Каталог", () -> {
            mainPage.submitNews();
        });
        step("Проверить что нахожусь на странице Новости", () -> {
            newsPage.checkNews(news);
        });
    }

    @DisplayName("Поиск в реестре по автору и произведению")
    @Test
    void russianRegistrySearchWorkAuthorTest(){
        step("Открыть страницу Российского реестра произведений", () -> {
            ruRegistryPage.openPage();
        });
        step("В поле Произведение ввести название произведения", () -> {
            ruRegistryPage.setWork(work);
        });
        step("В поле Автор ввести ФИО фвтора", () -> {
            ruRegistryPage.setAuthor(author);
        });
        step("Нажать кнопку Поиск", () -> {
            ruRegistryPage.submitClick();
        });
        step("Проверить нахождение произведения в результатах поиска", () -> {
            ruRegistryPage.checkForm(value);
        });
    }

    @DisplayName("Поиск в реестре по произведению")
    @Test
    void russianRegistrySearchWorkTest(){
        step("Открыть страницу Российского реестра произведений", () -> {
            ruRegistryPage.openPage();
        });
        step("В поле Произведение ввести название произведения", () -> {
            ruRegistryPage.setWork(work1);
        });
        step("Нажать кнопку Поиск", () -> {
            ruRegistryPage.submitClick();
        });
        step("Проверить нахождение произведения в результатах поиска", () -> {
            ruRegistryPage.checkForm(work1);
        });
    }

    @DisplayName("Поиск в реестре по автору")
    @Test
    void russianRegistrySearchAuthorTest(){
        step("Открыть страницу Российского реестра произведений", () -> {
            ruRegistryPage.openPage();
        });
        step("В поле Автор ввести ФИО фвтора", () -> {
            ruRegistryPage.setAuthor(author1);
        });
        step("Нажать кнопку Поиск", () -> {
            ruRegistryPage.submitClick();
        });
        step("Проверить нахождение Автора в результатах поиска", () -> {
            ruRegistryPage.checkForm(author1);
        });
    }
}
