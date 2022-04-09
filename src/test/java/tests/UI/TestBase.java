package tests.UI;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.Attach;
import helpers.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.CareersPage;
import pages.MainPage;
import pages.SalesPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    static Faker faker = new Faker();
    SalesPage salesPage = new SalesPage();
    CareersPage careersPage = new CareersPage();
    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}