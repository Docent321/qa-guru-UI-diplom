package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:Config${type}.properties"})

public interface  CredentialsConfig extends Config {

    @Key("browserName")
    String browserName();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

    @Key("remoteUrl")
    String remoteUrl();

//    @Key("user")
//    String user();
//
//    @Key("password")
//    String password();
}
