package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !config.remoteUrl().equals("");
    }

    public static String browserName() {
        return config.browserName();
    }

    public static String browserVersion() {
        return config.browserVersion();
    }

    public static String browserSize() {
        return config.browserSize();
    }

}
