package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RuRegistryPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static testData.TestData.*;

public class RaoTest extends TestBase{

    RuRegistryPage ruRegistryPage = new RuRegistryPage();

    @DisplayName("Главная страница")
    @Test
    void homePageTest(){
        step("Открыть главную страницу", () -> {
            open("https://www.rao.ru/");
        });
        step("Проверить наличие надписи РОССИЙСКОЕ АВТОРСКОЕ ОБЩЕСТВО в хедере", () -> {
            $(".logo-section").shouldHave(text("РОССИЙСКОЕ АВТОРСКОЕ ОБЩЕСТВО"));
        });
    }

    @DisplayName("Переход в раздел Новости")
    @Test
    void newsRaoTest(){
        step("Открыть главную страницу", () -> {
            open("https://rao.ru/");
        });
        step("Кликнуть на кнопку Каталог", () -> {
            $("#menu-item-4955").click();
        });
        step("Проверить что нахожусь на странице Новости", () -> {
            $(".news-page").shouldHave(text("НОВОСТИ"));
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
