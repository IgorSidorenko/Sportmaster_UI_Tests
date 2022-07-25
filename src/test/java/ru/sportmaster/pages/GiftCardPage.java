package ru.sportmaster.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class GiftCardPage {

    @Step("Открыть страницу электронной подарочной карты")
    public GiftCardPage openPage() {
        open("/giftcard/e-giftcard/");
        return this;
    }

    @Step("Ввести телефон получателя")
    public GiftCardPage addRecipientPhoneNumber(String recipientPhone) {
        $("[data-selenium=\"phone\"] input").setValue(recipientPhone);
        return this;
    }

    @Step("Ввести email получателя")
    public GiftCardPage addRecipientEmail(String recipientEmail) {
        $("[data-selenium=\"email\"] input").setValue(recipientEmail);
        return this;
    }

    @Step("Ввести email отправителя")
    public GiftCardPage addSenderEmail(String senderEmail) {
        $("[placeholder=\"Введите почту отправителя\"]").setValue(senderEmail);
        return this;
    }

    @Step("Ввести приветствие")
    public GiftCardPage addGreeting(String greeting) {
        $("[data-selenium=\"greeting\"] input").setValue(greeting);
        return this;
    }

    @Step("Ввести текст поздравления")
    public GiftCardPage addGreetingsText(String greetingsText) {
        $("[placeholder=\"Ваш текст\"]").setValue(greetingsText);
        return this;
    }

    @Step("Добавить подпись")
    public GiftCardPage addSignature(String signature) {
        $("[data-selenium=\"signature\"] input").setValue(signature);
        return this;
    }

    @Step("Принять правила")
    public GiftCardPage confirmRules() {
        $("[data-selenium=\"checkbox\"]").scrollIntoView(true).click();
        return this;
    }

    @Step("Нажать кнопку перехода к оплате")
    public GiftCardPage pushGoToPaymentButton() {
        $("[data-selenium=\"submitButton\"]").click();
        return this;
    }

    @Step("Проверить, что открылась страница оплаты")
    public void checkPaymentPage() {
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        url.contains("securepayments.sberbank.ru");
    }
}