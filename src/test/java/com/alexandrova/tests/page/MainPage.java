package com.alexandrova.tests.page;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {
    public MainPage openMainPage() {
        step("Открыть главную страницу сайта \"KonturVacancies\"", () -> open(""));
        return this;
    }

    public MainPage chechLogoFontSize(){
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

}
