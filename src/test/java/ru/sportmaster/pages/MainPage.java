package ru.sportmaster.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("open site")
    public MainPage openMain() {
        open("/");
        return this;
    }

    @Step("open basket site")
    public BasketPage goToBasket() {
        open("/cart/");
        return new BasketPage();
    }

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Открыть форму выбора города")
    public MainPage openSelectCityForm() {
        $("[data-selenium=\"cityButton\"]").click();
        return this;
    }

    @Step("Ввести название города")
    public MainPage addCity(String city) {
        $("[data-selenium=\"top-cities-list\"]").$(byText(city)).click();
        sleep(2000);
        return this;
    }

    @Step("Проверить, что город изменился")
    public void checkCityChange(String city) {
        $("[data-selenium=\"cityButton\"]")
                .should(Condition.text(city))
                .should(Condition.visible);
    }

    @Step("Ввести в строку поиска {0}")
    public MainPage typeSearchWord(String searchWord) {
        $("[placeholder=\"Поиск\"]")
                .setValue(searchWord)
                .pressEnter();
        return this;
    }

    @Step("Проверить, что найдены товары по запросу {0}")
    public void checkGoodsFound(String searchWord) {
        $("[data-selenium=\"category-title\"]")
                .should(Condition.text(searchWord))
                .should(Condition.visible);
    }
}
