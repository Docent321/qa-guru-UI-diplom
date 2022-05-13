package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static testData.TestData.*;

public class Rao extends TestBase {

    @Test
    @Tag("web")
    @Owner("AlexDonskov")
    @DisplayName("Главная страница")
    void homePageTest(){
        step("Открыть главную страницу", () ->
                mainPage.openPage());
        step("Проверить наличие надписи РОССИЙСКОЕ АВТОРСКОЕ ОБЩЕСТВО в хедере", () ->
                mainPage.checkForm(logo));
    }

    @Test
    @Tag("web")
    @Owner("AlexDonskov")
    @DisplayName("Переход в раздел Новости")
    void newsRaoTest(){
        step("Открыть главную страницу", () ->
                mainPage.openPage());
        step("Нажать на кнопку Каталог", () ->
                mainPage.submitNews());
        step("Проверить что нахожусь на странице Новости", () ->
                newsPage.checkForm(news));
    }

    @Test
    @Tag("web")
    @Owner("AlexDonskov")
    @DisplayName("Поиск в реестре по автору и произведению")
    void russianRegistrySearchWorkAuthorTest(){
        step("Открыть страницу Российского реестра произведений", () ->
                ruRegistryPage.openPage());
        step("В поле Произведение ввести название произведения", () ->
                ruRegistryPage.setWork(work));
        step("В поле Автор ввести ФИО фвтора", () ->
                ruRegistryPage.setAuthor(author));
        step("Нажать кнопку Поиск", () ->
                ruRegistryPage.clickSubmit());
        step("Проверить нахождение произведения в результатах поиска", () ->
                ruRegistryPage.checkForm(value));
    }

    @Test
    @Tag("web")
    @Owner("AlexDonskov")
    @DisplayName("Поиск в реестре по произведению")
    void russianRegistrySearchWorkTest(){
        step("Открыть страницу Российского реестра произведений", () ->
                ruRegistryPage.openPage());
        step("В поле Произведение ввести название произведения", () ->
                ruRegistryPage.setWork(work1));
        step("Нажать кнопку Поиск", () ->
                ruRegistryPage.clickSubmit());
        step("Проверить нахождение произведения в результатах поиска", () ->
                ruRegistryPage.checkForm(work1));
    }

    @Test
    @Tag("web")
    @Owner("AlexDonskov")
    @DisplayName("Поиск в реестре по автору")
    void russianRegistrySearchAuthorTest(){
        step("Открыть страницу Российского реестра произведений", () ->
                ruRegistryPage.openPage());
        step("В поле Автор ввести ФИО фвтора", () ->
                ruRegistryPage.setAuthor(author1));
        step("Нажать кнопку Поиск", () ->
                ruRegistryPage.clickSubmit());
        step("Проверить нахождение Автора в результатах поиска", () ->
                ruRegistryPage.checkForm(author1));
    }
}
