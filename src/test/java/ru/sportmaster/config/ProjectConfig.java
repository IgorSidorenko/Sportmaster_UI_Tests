package ru.sportmaster.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:./src/test/resources/config/localBrowser.properties",
})
public interface ProjectConfig extends Config {
    String client();
    @DefaultValue("https://www.sportmaster.ru")
    String baseUrl();
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("101.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}