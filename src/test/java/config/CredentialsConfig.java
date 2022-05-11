package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${type}.properties"})

public interface  CredentialsConfig extends Config {

    @Key("user")
    String user();

    @Key("password")
    String password();

    @Key("browserName")
    String browserName();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("videoStorage")
    String videoStorage();

    @Key("timeoutVideoAttach")
    int timeoutVideoAttach();

    @Key("timeout")
    int timeout();
}
