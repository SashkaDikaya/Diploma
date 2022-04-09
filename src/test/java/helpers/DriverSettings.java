package helpers;

import com.codeborne.selenide.Configuration;
import config.CredentialConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {

    static CredentialConfig credentials = ConfigFactory.create(CredentialConfig.class);

    public static void configure(){
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

        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Version: ", version);
        Attach.attachAsText("Remote Url: ", remoteUrl);
    }
}