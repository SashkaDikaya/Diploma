package tests.UI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class VeeamPOStepsTests extends TestBase {

    final String
            phrase = "QA Automation";

    @Test
    @DisplayName("Поиск вакансии " + phrase)
    void findVacancyTest() {
        pageObject.selectCzechia()
                .findVacancy(phrase)
                .checkVacancy(phrase);
    }

    final String
            language = "English",
            languageShort = "EN";

    /*@Test
    @DisplayName("Смена языка с русского на " + language)
    void changeLanguageTest() {
        pageObject.changeLanguage(language)
                .checkLanguage(languageShort);
    }

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().phoneNumber(),
            company = faker.ancient().god(),
            details = faker.elderScrolls().quote();

    @Test
    @DisplayName("Заполнение Запроса в отдел продаж")
    void fillFormTest() {
        pageObject.fillForm(firstName, lastName, email, phone, company, details);
    }*/

}



