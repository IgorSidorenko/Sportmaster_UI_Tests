package ru.sportmaster.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.sportmaster.config.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.sportmaster.helpers.AllureAttachments;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBaseWeb {

    static ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
    static String selenoidURL;

    @BeforeAll
    static void setUp() {

        String login = config.login();
        String password = config.password();
        String browser = config.browser();
        String browserVersion = config.browserVersion();
        String baseUrl = config.baseUrl();
        String browserSize = config.browserSize();
        selenoidURL = System.getProperty("selenoidURL");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        if (selenoidURL != null) {
            Configuration.remote = "https://" + login + ":" + password + "@" + selenoidURL;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", browser);
            capabilities.setCapability("browserVersion", browserVersion);
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs("Test screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo(selenoidURL);
        closeWebDriver();
    }
}
