package tests.UI;

import com.codeborne.pdftest.PDF;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class Tests extends TestBase {

    final String
            phrase = "QA Automation",
            language = "English",
            languageShort = "EN",
            country = "Чехия";

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().phoneNumber(),
            company = faker.ancient().god(),
            details = faker.elderScrolls().quote();

    @Test
    @AllureId("8172")
    @DisplayName("Поиск вакансии " + phrase)
    void findVacancyTest() {
        careersPage.selectCountry(country)
                .findVacancy(phrase)
                .checkVacancy(phrase);
    }

    /*@Test
    @AllureId("8175")
    @DisplayName("Смена языка с русского на " + language)
    void changeLanguageTest() {
        mainPage.changeLanguage(language)
                .checkLanguage(languageShort);
    }

    @Test
    @AllureId("8176")
    @DisplayName("Заполнение Запроса в отдел продаж")
    void fillFormTest() {
        salesPage.fillForm(firstName, lastName, email, phone, company, details);
    }

    @ValueSource(strings = {"Biocad", "Exchange", " ВСК", "Exchange"})
    @ParameterizedTest(name = "Открытие статьи о : {0}")
    @AllureId("8170")
    void checkSuccessStoryTest(String customer) {
        step("Открытие главной страницы сайта Veeam", () ->
                open("https://www.veeam.com/ru"));

        step("Открытие историй успеха заказчиков", () ->
                $x("//a[text()='Истории успеха заказчиков']").click());

        step("Поиск информации о " + customer, () -> {
            $x("//span[contains(text(),'Показать поле поиска')]").click();
            $x("//input[@class='form-input search-input']").setValue(customer).pressEnter();
        });

        step("Проверка наличия статьи о " + customer, () ->
                $x("//div[@class='success-stories-listing__listing']").shouldHave(text(customer)));

        step("Открытие первой статьи о " + customer, () ->
                $x("//a[text()='Подробнее']").click());

        step("Проверка наличия информации в статье о " + customer, () ->
                $x("//*").shouldHave(text(customer)));
    }

    @Test
    @AllureId("8171")
    @DisplayName("Поиск информации о компании Biocad в скачанном PDF файле")
    void checkPdfTest() throws Exception {
        step("Поиск информации о компании Biocad в скачанном PDF файле", () -> {
            open("https://www.veeam.com/ru/success-stories/Biocad.html");
            File downloadedPdfFile = $x("//span[contains(text(), 'Скачать PDF')]/..").download();
            PDF parsed = new PDF(downloadedPdfFile);

            assertThat(parsed.title).contains("Veeam", "Biocad");
        });
    }*/
}