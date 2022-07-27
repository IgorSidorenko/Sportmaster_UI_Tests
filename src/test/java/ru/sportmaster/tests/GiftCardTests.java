package ru.sportmaster.tests;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.sportmaster.pages.GiftCardPage;

public class GiftCardTests extends TestBaseWeb {

    GiftCardPage giftCardPage = new GiftCardPage();

    String recipientPhone = "99912312333";
    String recipientEmail = "test@test.ru";
    String senderEmail = "test2@test2.ru";
    String greeting = "Dear friend";
    String greetingsText = "Have a nice day";
    String signature = "Sincerely yours";


    @Test
    @AllureId("11714")
    @DisplayName("Заполнение формы подарочной карты")
    @Tag("UI")
    public void userGoToPaymentPageAfterFillForm() {
        giftCardPage.openPage()
                .addRecipientPhoneNumber(recipientPhone)
                .addRecipientEmail(recipientEmail)
                .addSenderEmail(senderEmail)
                .addGreeting(greeting)
                .addGreetingsText(greetingsText)
                .addSignature(signature)
                .confirmRules()
                .pushGoToPaymentButton()
                .checkPaymentPage();
    }
}