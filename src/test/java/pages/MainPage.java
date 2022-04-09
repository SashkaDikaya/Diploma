package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    SelenideElement
            languageSelectorButton = $x("//div[@class='language-selector']"),
            languageDDList = $x("//div[@class='language-selector__dropdown']");

    @Step("Смена языка с русского на {0}")
    public MainPage changeLanguage(String language) {
        Selenide.open("https://www.veeam.com/ru");
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
