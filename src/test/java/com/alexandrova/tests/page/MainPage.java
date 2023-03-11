package com.alexandrova.tests.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {

    private final SelenideElement discussYourProject = $(byText("Написать письмо"));
    private final SelenideElement firstName = $x("/html/body/div[8]/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div/div/span/div[2]/div/div/span/label/span[2]/input");
    private final SelenideElement email = $x("/html/body/div[8]/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div/div/span/div[3]/div/div/span/label/span[2]/input");
  //  private final SelenideElement picture = $x("/html/body/div[8]/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div/div/span/div[5]/div/div/form/input");
    private final SelenideElement picture = $("#body > div:nth-child(41) > div > div > div.react-ui-g3exw9 > div > div.default-default_-Q_XX.Main-container_1zND9 > div.Main-content_337ET > div.styles-mailWrapper_1vjwd > div > div > div > span > div:nth-child(5) > div > div > form > input[type=file]");
    private final SelenideElement userQuestion = $(".react-ui-1xg197j");

    public MainPage openMainPage() {
        step("Открыть главную страницу сайта \"KonturVacancies\"", () -> open(""));
        return this;
    }

    public MainPage chechLogoFontSize() {
        step("Проверить лого сайта 'параметры СSS'", () ->
                $(".kontur-logo-image").shouldHave(cssValue("width", "94px")));
        $(".kontur-logo-image").shouldHave(cssValue("height", "32px"));
        $(".kontur-logo-image").shouldHave(cssValue("box-sizing", "border-box"));
        $(".kontur-logo-image").shouldHave(cssValue("color", "rgba(1, 92, 203, 1)"));
        $(".kontur-logo-image").shouldHave(cssValue("font", "0px / 0px \"Lab Grotesque\", -apple-system, BlinkMacSystemFont, Arial, \"Liberation Sans\", \"Nimbus Sans L\", sans-serif"));
        return this;
    }

    public MainPage goToPage(String name) {
        step(String.format("Перейти на страницу раздела \"%s\"", name), () -> $(byText(name)).click());
        return this;
    }

    public MainPage checkPageTitle(String disc) {
        step(String.format("Проверить заголовок на странице раздела \"%s\"", disc), () ->
                $(".page-layout__inner").shouldHave(text(disc)));
        return this;
    }

    public MainPage searchInput(String testData) {
        step(String.format("Ввести поисковой запрос \"%s\"", testData), () -> {
            $(".footer-search__input").setValue(testData).pressEnter();
        });
        return this;
    }

    public MainPage checkSearchResult(String expectedResult) {
        step(String.format("Проверить, что результат поиска содержит ответ \"%s\"", expectedResult), () ->
                $(".result__title").shouldHave(text(expectedResult)));
        return this;
    }

    public MainPage goDiscussYourProject() {
        step("Открыть форму заполнения 'Написать письмо'", () -> discussYourProject.click());
        return this;
    }

    public MainPage typeFirstName(String value) {
        step("Заполнить поле 'Имя'", () -> firstName.setValue(value));

        return this;
    }

    public MainPage userEmail(String userEmail) {
        step(("Заполнить поле 'Email'"), () -> email.setValue(userEmail));
        return this;
    }

    public MainPage setPictureImg(File file) {
        step(("Добавить файл png. "), () -> picture.uploadFile(file));
        return this;
    }

    public MainPage userQuestion(String question) {
        step(("Заполнить поле 'вопроса'"), () -> userQuestion.setValue(question));
        return this;
    }

    public MainPage sendButton() {
        step(("Нажать кнопку 'Отправить'"), () -> $(byText("Отправить письмо")).click());
        return this;
    }

    public MainPage checkSendResult() {
        step(("Проверить, что результат поиска содержит ответ "), () ->
                $x("/html/body/div[8]/div/div/div[2]/div/div/div[2]/div[2]/div/p[2]").shouldHave(text("Ответим вам на электронную почту")));
        return this;
    }

    public MainPage checkPageContent(String lang, List<String> expectedTitle) {
        step(String.format("Проверить отображение разделов %s", expectedTitle), () ->
                $$(".header-menu_align-right").filter(visible).shouldHave(CollectionCondition.texts(expectedTitle)));
        return this;
    }

    public MainPage openEnPage() {
        step("Выбрать язык Eng", () -> open("https://kontur-inc.com/"));
        return this;
    }
}
