package ru.sportmaster.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {
    private SelenideElement deleteAll = $("[data-selenium='cart-group-delete']");
    private ElementsCollection itemGoods = $$("[data-selenium='basket-item']");

    @Step("Delete all items")
    public BasketPage deleteGoods() {
        deleteAll.click();
        return this;
    }

    @Step("Check delete all items")
    public BasketPage checkItems(int count) {
        itemGoods.shouldHave(size(count));
        return this;
    }
}
