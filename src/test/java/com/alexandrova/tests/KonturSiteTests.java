package com.alexandrova.tests;

import com.alexandrova.tests.page.MainPage;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.File;
import java.util.List;
import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.sleep;

@Feature("UI тесты")
@Owner("Alexandrova Lena")
@Severity(SeverityLevel.NORMAL)
@DisplayName("UI тесты для сайта kontur.ru")
@Tags({@Tag("WEB"), @Tag("MEDIUM"), @Tag("NORMAL")})
@Link(name = "Kontur", url = "https://kontur.ru/career/")

public class KonturSiteTests extends TestBase {

    private final MainPage mainPage = new MainPage();
    private final Faker faker = new Faker();
    private String firstName;
    private String userEmail;
    private String file;
    private String question;
    private String fileLocation;

    @BeforeEach
    void setUp() {
        file = "1.png";
        firstName = faker.name().firstName();
        userEmail = faker.internet().emailAddress();
        question = faker.harryPotter().location();
        fileLocation = "src/test/resources/img/";
    }

    @Test
    @Tag("logo")
    @AllureId("15942")
    @DisplayName("Проверка логотипа сайта на 'параметры CSS'")
    void konturLogoTest() {
        mainPage.openMainPage();
        mainPage.chechLogoFontSize();
    }

    @Tag("page")
    @AllureId("15870")
    @DisplayName("Проверка перехода в разделы сайта.")
    @ParameterizedTest(name = "Выполняется переход в раздел \"{0}\"")
    @CsvSource(value = {
            "Вакансии, Продажи и работа с клиентами",
            "Кандидатам, Как попасть на работу в Контур",
            "Cтудентам, Образовательные программы",})
    void testWithCsvSource(String name, String disc) {
        mainPage.openMainPage();
        mainPage.goToPage(name);
        mainPage.checkPageTitle(String.valueOf(disc));
    }

    @Tag("search")
    @AllureId("15941")
    @DisplayName("Проверка работы поиска.")
    @CsvSource(value = {"Вакансии, Услуга по созданию"})
    @ParameterizedTest(name = "Результаты поиска содержат текст \"{1}\" для запроса \"{0}\"")
    void konturSearch(String testData, String expectedResult) {
        mainPage.openMainPage();
        mainPage.searchInput(testData);
        mainPage.checkSearchResult(expectedResult);
    }

    @Test
    @Tag("form")
    @AllureId("15940")
    @DisplayName("Проверка заполнения формы 'Написать письмо'")
    void konturWriteEmail() {
        mainPage.openMainPage();
        mainPage.goDiscussYourProject();
        mainPage.typeFirstName(firstName);
        mainPage.userEmail(userEmail);
        mainPage.setPictureImg(new File(fileLocation + file));
        mainPage.userQuestion(question);
        mainPage.sendButton();
        mainPage.checkSendResult();
    }

    static Stream<Arguments> konturSiteMenuTest() {
        return Stream.of(
                Arguments.of("English", List.of("Products\n" +
                        "Company\n" +
                        "Partnership\n" +
                        "Contact us\n")));
    }

    @MethodSource
    @AllureId("15943")
    @DisplayName("Проверка наличия разделов сайта на Англ.языке.")
    @ParameterizedTest(name = "Для языка {0} отображаются разделы {1}")
    void konturSiteMenuTest(String lang, List<String> expectedTitle) {
        mainPage.openEnPage();
        mainPage.checkPageContent(lang, expectedTitle);
        sleep(1500);
    }
}
