package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import com.geekbrains.lesson8.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement inputLogin = $(By.id("prependedInput"));

    private SelenideElement inputPassword = $(By.id("prependedInput2"));

    private SelenideElement buttonLogin = $(By.id("_submit"));

    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку 'Войти'")
    public MainPage submitLogin() {
        buttonLogin.click();
        return page(MainPage.class);
    }

    @Step("Логин на сайте")
    public void login(String login, String password) {
        open("https://crm.geekbrains.space/");
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }
}