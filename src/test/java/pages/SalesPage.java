package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SalesPage {

    SelenideElement
            firstNameInput = $x("//input[contains(@id, 'first-name')]"),
            lastNameInput = $x("//input[contains(@id, 'last-name')]"),
            emailInput = $x("//input[contains(@id, 'email')]"),
            phoneInput = $x("//input[contains(@id, 'phone')]"),
            companyInput = $x("//input[contains(@id, 'company')]"),
            detailsInput = $x("//textarea[contains(@id, 'details')]"),
            productsButton = $x("//div[@class='form-group js-products ']"),
            productsSearcher = $x("//input[@placeholder='Выберите продукт']"),
            oneProduct = $x("//div[contains(text(), 'Veeam ONE')]");

    @Step("Заполнение Запроса в отдел продаж")
    public SalesPage fillForm(String firstName, String lastName, String email, String phone,
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
