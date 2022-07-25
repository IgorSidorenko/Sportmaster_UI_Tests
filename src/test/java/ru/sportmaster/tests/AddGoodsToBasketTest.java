package ru.sportmaster.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
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
    @Tag("UI")
    @Owner("Sidorenko")
    @Story("Добавить товар в корзину")
    @Description("Проверка на добавление товара в корзину и количество товара в корзине равное 1")
    @DisplayName("Добавить товар в пустую корзину через карточку товара")
    void addGoodsToEmptyBasketFromDetailPage() {
        sleep(5000);
        step("Open 'https://www.sportmaster.ru'", () -> {
            open("/product/23117750299/");
            Selenide.zoom(0.65);
        });
        step("Выбрать размер", () -> {
            $("[data-selenium='product-sizes-item']").click();
            $(byText("В корзину")).click();
        });
        step("Кликнуть на 'Перейти в корзину'", () -> {
            $(byText("Перейти в корзину")).click();
        });
        step("Кол-во товара в корзине = 1", () -> {
            $$("[data-selenium='basket-item']").shouldHave(CollectionCondition.size(1));
        });
    }
}

    /*@Test
    @Tag("UI")
    @Owner("Sidorenko")
    @Story("Добавить товар в корзину")
    @Description("Проверка на добавление товара в корзину и количество товара в корзине равное 1")
    @DisplayName("Добавить товар в пустую корзину через поиск")
    void addGoodsToEmptyBasketFromSearchPage() {
        step("Open 'https://www.sportmaster.ru'", () -> {
            open("/");
        });
        step("Ввод текста 'Кеды' в поле поиска и нажать Enter", () -> {
            $("[data-selenium='smTextField']").setValue("Кеды").pressEnter();
        });
        step("Кликнуть на первый товара", () -> {
            $("[data-selenium='product-name']").scrollTo().hover();
            $("[data-selenium='addToCartButton']").click();
        });
        step("Выбрать размер", () -> {
            sleep(2000);
            Selenide.zoom(0.65);
            $("[data-selenium='product-sizes-item']").click();
            $("button[data-selenium='add-btn']").click();
        });

        step("Кликнуть на 'Перейти в корзину'", () -> {
            $("[data-selenium='sm_badge_item']").click();
        });
        step("Кол-во товара в корзине = 1", () -> {
            $$("[data-selenium='basket-item']").shouldHave(CollectionCondition.size(1));
        });*/

