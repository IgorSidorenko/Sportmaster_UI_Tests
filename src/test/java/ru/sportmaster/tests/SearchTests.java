package ru.sportmaster.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.sportmaster.pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBaseWeb {
    MainPage mainPage = new MainPage();
    String searchWord = "рюкзаки";

    @Test
    @Tag("UI")
    @DisplayName("Поиск заданной категории товара в каталоге")
    public void goodsCategoryShouldBeFound() {
        mainPage.openMainPage()
                .typeSearchWord(searchWord)
                .checkGoodsFound(searchWord);
    }
}