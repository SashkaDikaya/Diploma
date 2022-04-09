package pages;

import com.codeborne.selenide.SelenideElement;
import config.CredentialConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    CredentialConfig credentials = ConfigFactory.create(CredentialConfig.class);

    SelenideElement
            languageSelectorButton = $x("//div[@class='language-selector']"),
            languageDDList = $x("//div[@class='language-selector__dropdown']");

    @Step("Смена языка с русского на {0}")
    public MainPage changeLanguage(String language) {
        open(credentials.mainPageUrl());
        languageSelectorButton.click();
        languageDDList.$(withText(language)).click();
        return this;
    }

    @Step("Проверка что язык {0}")
    public MainPage checkLanguage(String languageShort) {
        languageSelectorButton.shouldHave(text(languageShort));
        return this;
    }
}
