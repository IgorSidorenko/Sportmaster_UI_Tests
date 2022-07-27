package ru.sportmaster.tests;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sportmaster.pages.MainPage;

public class ChangeCityTests extends TestBaseWeb {

    MainPage mainPage = new MainPage();
    String city = "Казань";

    @Test
    @AllureId("11715")
    @DisplayName("Изменение города")
    public void userCanChangeCity() {
        mainPage.openMainPage()
                .openSelectCityForm()
                .addCity(city)
                .checkCityChange(city);
    }
}