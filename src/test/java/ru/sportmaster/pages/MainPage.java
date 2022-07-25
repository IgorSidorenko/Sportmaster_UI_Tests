package ru.sportmaster.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.open;
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
}
