package tests.UI;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class VeeamLambdaStepsTests extends TestBase {

    @ValueSource(strings = {"Biocad", "Exchange"})
    @ParameterizedTest(name = "Открытие статьи о : {0}")
    @AllureId("8170")
    void checkSuccessStoryTest(String customer) {
        step("Открытие главной страницы сайта Veeam", () -> {
            Selenide.open("https://www.veeam.com/ru");
        });

        step("Открытие историй успеха заказчиков", () -> {
            $x("//a[text()='Истории успеха заказчиков']").click();
        });

        step("Поиск информации о " + customer, () -> {
            $x("//span[contains(text(),'Показать поле поиска')]").click();
            $x("//input[@class='form-input search-input']").setValue(customer).pressEnter();
        });

        step("Проверка наличия статьи о " + customer, () -> {
            $x("//div[@class='success-stories-listing__listing']").shouldHave(text(customer));
        });

        step("Открытие первой статьи о " + customer, () -> {
            $x("//a[text()='Подробнее']").click();
        });

        step("Проверка наличия информации в статье о " + customer, () -> {
            $x("//*").shouldHave(text(customer));
        });
    }

    @Test
    @AllureId("8171")
    @DisplayName("Поиск информации о компании Biocad в скачанном PDF файле")
    void checkPdfTest() throws Exception {
        step("Поиск информации о компании Biocad в скачанном PDF файле", () -> {
            Selenide.open("https://www.veeam.com/ru/success-stories/Biocad.html");
            File downloadedPdfFile = $x("//span[contains(text(), 'Скачать PDF')]/..").download();
            PDF parsed = new PDF(downloadedPdfFile);
            assertThat(parsed.title).contains("Veeam", "Biocad");

        });
    }


}



