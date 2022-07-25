package ru.sportmaster.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GiftCardTests extends TestBaseWeb {

    String recipientPhone = "99912312333";
    String recipientEmail = "test@test.ru";
    String senderEmail = "test2@test2.ru";
    String greeting = "Dear friend";
    String greetingsText = "Have a nice day";
    String signature = "Sincerely yours";


    @Test
    @Tag("UI")
    @DisplayName("Заполнение формы подарочной карты")
    public void userGoToPaymentPageAfterFillForm() {
        step("Открыть страницу электронной подарочной карты", () -> open("/giftcard/e-giftcard/"));
        step("Ввести телефон получателя", () ->
                $("[data-selenium=\"phone\"] input").setValue(recipientPhone));
        step("Ввести email получателя", () ->
                $("[data-selenium=\"email\"] input").setValue(recipientEmail));
        step("Ввести email отправителя", () ->
                $("[placeholder=\"Введите почту отправителя\"]").setValue(senderEmail));
        step("Ввести приветствие", () ->
                $("[data-selenium=\"greeting\"] input").setValue(greeting));
        step("Ввести текст поздравления", () ->
                $("[placeholder=\"Ваш текст\"]").setValue(greetingsText));
        step("Добавить подпись", () ->
                $("[data-selenium=\"signature\"] input").setValue(signature));
        step("Принять правила", () ->
                $("[data-selenium=\"checkbox\"]").scrollIntoView(true).click());
        step("Нажать кнопку перехода к оплате", () ->
                $("[data-selenium=\"submitButton\"]").click());
        step("Проверить, что открылась страница оплаты", () ->
                WebDriverRunner.getWebDriver().getCurrentUrl().contains("securepayments.sberbank.ru"));
    }
}