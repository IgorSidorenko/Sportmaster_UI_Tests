package ru.sportmaster.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:/config/remoteBrowser.properties",
})
public interface ProjectConfig extends Config {

    String login();
    String password();
    @DefaultValue("https://www.sportmaster.ru")
    String baseUrl();
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("100.0")
    String browserVersion();
    @DefaultValue("1440x900")
    String browserSize();
}