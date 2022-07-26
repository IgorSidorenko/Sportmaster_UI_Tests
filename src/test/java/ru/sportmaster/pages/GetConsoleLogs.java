package ru.sportmaster.pages;

import com.codeborne.selenide.Selenide;

import static org.openqa.selenium.logging.LogType.BROWSER;

public class GetConsoleLogs {
    public static String getConsoleLogs() { // todo refactor
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
