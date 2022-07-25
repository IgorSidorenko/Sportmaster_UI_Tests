package ru.sportmaster.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.sportmaster.config.Project;
import ru.sportmaster.drivers.BrowserDriver;
import ru.sportmaster.helpers.AllureAttachments;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static ru.sportmaster.helpers.DriverUtils.getSessionId;

@ExtendWith({AllureJunit5.class})
public class TestBaseWeb{
    @BeforeAll
    public static void setup() {
        BrowserDriver.configure();
    }

    public static void addAllureSelenide() {
        addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = "";
        if (Project.isRemoteWebDriver()) {
            sessionId = getSessionId();
        }
        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        if (Project.isVideoOn()) {
            AllureAttachments.addVideoBrowser(sessionId);
        }
    }
}