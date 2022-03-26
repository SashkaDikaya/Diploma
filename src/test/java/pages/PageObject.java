package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$x;

public class PageObject {

    SelenideElement
            countrySelector = $x("//div[@class='dropdown nav-item']//a[@id='site-switcher']"),
            countryDDList = $x("//div[@aria-labelledby='site-switcher']"),
            searcherButton = $x("//div[@class='dropdown-search dropdown nav-item']"),
            searcherInput = $x("//input"),
            allPage = $x("//*"),

            languageSelectorButton = $x("//div[@class='language-selector']"),
            languageDDList = $x("//div[@class='language-selector__dropdown']"),

            firstNameInput = $x("//input[contains(@id, 'first-name')]"),
            lastNameInput = $x("//input[contains(@id, 'last-name')]"),
            emailInput = $x("//input[contains(@id, 'email')]"),
            phoneInput = $x("//input[contains(@id, 'phone')]"),
            companyInput = $x("//input[contains(@id, 'company')]"),
            detailsInput =  $x("//textarea[contains(@id, 'details')]"),
            productsButton =  $x("//div[@class='form-group js-products ']"),
            productsSearcher = $x("//input[@placeholder='Выберите продукт']"),
            oneProduct = $x("//div[contains(text(), 'Veeam ONE')]");

    //FirstTest
    @Step("Выбор страны Чехия")
    public PageObject selectCzechia () {
        Selenide.open("https://careers.veeam.ru/");
        countrySelector.click();
        countryDDList.$(withText("Чехия")).click();

        return this;
    }

    @Step("Поиск вакансии {0}")
    public PageObject findVacancy (String phrase) {
        searcherButton.click();
        searcherInput.setValue(phrase).pressEnter();

        return this;
    }

    @Step("Открытие вакансии содержащую {0}")
    public PageObject checkVacancy (String phrase) {
        allPage.shouldHave(text(phrase + " Engineer")).click();

        return this;
    }

    //SecondTest
    @Step("Смена языка с русского на {0}")
    public PageObject changeLanguage (String language) {
        Selenide.open("https://www.veeam.com/ru");
        languageSelectorButton.click();
        languageDDList.$(withText(language)).click();
        return this;
    }

    @Step("Проверка что язык {0}")
    public PageObject checkLanguage (String languageShort) {
        languageSelectorButton.shouldHave(text(languageShort));
        return this;
    }

    //ThirdTest
    @Step("Заполнение Запроса в отдел продаж")
    public PageObject fillForm (String firstName, String lastName, String email, String phone,
                                String company, String details) {
        Selenide.open("https://www.veeam.com/ru/salesinc.html?ad=in-text-link");
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        phoneInput.setValue(phone);
        companyInput.setValue(company);
        detailsInput.setValue(details);
        productsButton.click();
        productsSearcher.setValue("ONE");
        oneProduct.click();

        return this;
    }

}
