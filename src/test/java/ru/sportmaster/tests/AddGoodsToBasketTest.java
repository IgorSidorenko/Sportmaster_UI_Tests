package ru.sportmaster.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AddGoodsToBasketTest extends TestBaseWeb {

    @Test
    @AllureId("11717")
    @DisplayName("Добавить товар в пустую корзину через карточку товара")
    @Tag("UI")
    @Story("Добавить товар в корзину")
    @Owner("Sidorenko")
    @Description("Проверка на добавление товара в корзину и количество товара в корзине равное 1")
    void addGoodsToEmptyBasketFromDetailPage() {
        step("Open '/product/23117750299/'", () -> {
            open("/product/23117750299/");
        });
        step("Выбрать размер и добавить в корзину", () -> {
            $("[data-selenium='product-sizes-item']").click();
            $(byText("В корзину")).click();
        });
        step("Кликнуть на 'Перейти в корзину'", () ->
            $(byText("Перейти в корзину")).click());

        step("Кол-во товара в корзине = 1", () ->
            $$("[data-selenium='basket-item']").shouldHave(CollectionCondition.size(1)));

    }
}

