package ru.sportmaster.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class CheckSiteTest extends TestBaseWeb {

    @Test
    @AllureId("11716")
    @DisplayName("Page title should have header text")
    @Tag("UI")
    @Story("Smoke check page")
    @Owner("Sidorenko")
    @Description("Проверка title сайта sportmaster")
    void titleTest() {
        Selenide.zoom(0.75);
        step("Open 'https://www.sportmaster.ru/'", () ->
                open("/"));

        step("Page title should have text 'Спортмастер — спортивный магазин для всей семьи!'", () -> {
            String expectedTitle = "Спортмастер — спортивный магазин для всей семьи!";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @AllureId("11718")
    @DisplayName("Page console log should not have errors")
    @Tag("UI")
    @Story("Smoke check page")
    @Owner("Sidorenko")
    @Description("Проверка на отсутствие ошибок в консоли сайта")
    void consoleShouldNotHaveErrorsTest() {
        step("Open 'https://www.sportmaster.ru/'", () ->
                open("/"));

        step("Console logs should not contain text '500'", () -> {
            String consoleLogs = GetConsoleLogs.getConsoleLogs();
            String errorText = "500";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
