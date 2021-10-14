package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BaseView {

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonLogin;

    @FindBys({
            @FindBy(xpath = "//div"),
            @FindBy(xpath = "//a")
    })
    public WebElement test;

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
        return new MainPage(webDriver);
    }
    @Step("Логин на сайте")
    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
}