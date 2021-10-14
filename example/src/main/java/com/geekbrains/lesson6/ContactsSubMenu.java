package com.geekbrains.lesson6;

import com.geekbrains.lesson6.BaseView;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsSubMenu extends BaseView {
    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement createContactButton;

    public ContactsSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клик на кнопку Контактные лица")
    public ContactsPage contactsButtonClick() {
        createContactButton.click();
        return new ContactsPage(webDriver);
    }
}
