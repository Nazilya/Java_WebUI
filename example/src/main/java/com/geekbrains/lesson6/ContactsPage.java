package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BaseView {
    public ContactsPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//a[.='Создать контактное лицо']")
    public WebElement createContactButton;

    @Step("Клик на кнопку создания контактного лица")
    public ContactsPage createContactButtonClick() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать контактное лицо']")));
        createContactButton.click();
        return new ContactsPage(webDriver);
    }
}
