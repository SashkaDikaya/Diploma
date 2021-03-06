package pages;

import com.codeborne.selenide.SelenideElement;
import config.CredentialConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CareersPage {
    CredentialConfig credentials = ConfigFactory.create(CredentialConfig.class);

    SelenideElement
            countrySelector = $x("//div[@class='dropdown nav-item']//a[@id='site-switcher']"),
            countryDDList = $x("//div[@aria-labelledby='site-switcher']"),
            searcherButton = $x("//div[@class='dropdown-search dropdown nav-item']"),
            searcherInput = $x("//input");

    @Step("Выбор страны {0}")
    public CareersPage selectCountry(String country) {
        open(credentials.careersUrl());
        countrySelector.click();
        countryDDList.$(withText(country)).click();
        return this;
    }

    @Step("Поиск вакансии {0}")
    public CareersPage findVacancy(String phrase) {
        searcherButton.click();
        searcherInput.setValue(phrase).pressEnter();
        return this;
    }

    @Step("Открытие вакансии содержащую {0}")
    public CareersPage checkVacancy(String phrase) {
        $(byText(phrase + " Engineer")).click();
        return this;
    }
}