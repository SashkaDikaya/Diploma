package tests.UI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import config.CredentialConfig;
import helper.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CareersPage;
import pages.MainPage;
import pages.SalesPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    static CredentialConfig credentials = ConfigFactory.create(CredentialConfig.class);

    static Faker faker = new Faker();
    SalesPage salesPage = new SalesPage();
    CareersPage careersPage = new CareersPage();
    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        String remoteUrl = System.getProperty("remoteUrl", credentials.remoteUrl());
        String login = System.getProperty("login", credentials.login());
        String password = System.getProperty("pass", credentials.password());
        String browser = System.getProperty("browser", credentials.browser());
        String version = System.getProperty("version", credentials.version());
        String size = System.getProperty("size", credentials.size());

        String url = "https://" + login + ":" + password + "@" + remoteUrl;
        Configuration.remote = url;
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        Configuration.browserSize = size;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());

        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Version: ", version);
        Attach.attachAsText("Remote Url: ", remoteUrl);
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