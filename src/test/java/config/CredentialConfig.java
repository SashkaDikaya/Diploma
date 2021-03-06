package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface  CredentialConfig extends Config {
    String login();
    String password();
    String remoteUrl();
    String browser();
    String version();
    String size();
    String careersUrl();
    String mainPageUrl();
    String videoAttachUrl();
}