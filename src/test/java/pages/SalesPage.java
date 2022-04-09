package pages;

import com.codeborne.selenide.SelenideElement;
import config.CredentialConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SalesPage {

    CredentialConfig credentials = ConfigFactory.create(CredentialConfig.class);

    SelenideElement
            firstNameInput = $x("//input[contains(@id, 'first-name')]"),
            lastNameInput = $x("//input[contains(@id, 'last-name')]"),
            emailInput = $x("//input[contains(@id, 'email')]"),
            phoneInput = $x("//input[contains(@id, 'phone')]"),
            companyInput = $x("//input[contains(@id, 'company')]"),
            detailsInput = $x("//textarea[contains(@id, 'details')]"),
            productsButton = $x("//div[@class='form-group js-products ']"),
            productsSearcher = $x("//input[@placeholder='Выберите продукт']"),
            oneProduct = $x("//div[contains(text(), 'Veeam ONE')]"),
            sendButton = $x("button[contains(text(), 'запрос')]"),
            sendMessageBlock = $x("//div[@class='ty-component__title']");

    @Step("Заполнение Запроса в отдел продаж")
    public SalesPage fillForm(String firstName, String lastName, String email, String phone,
                              String company, String details) {
        open(credentials.mainPageUrl() + "salesinc.html?ad=in-text-link/");
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

    @Step("Отправка запроса в отдел продаж")
    public SalesPage sendRequest() {
        sendButton.click();
        return this;
    }

    @Step("Проверка что запрос успешно отправлен")
    public SalesPage requestCheck(String firstName) {
        sendMessageBlock.shouldHave(text(firstName));
        return this;
    }
}