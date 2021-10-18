package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ContactsSubMenu {
    private SelenideElement createContactButton = $(By.xpath("//span[text()='Контактные лица']"));

    @Step("Клик на кнопку Контактные лица")
    public ContactsPage contactsButtonClick() {
        createContactButton.click();
        return page(ContactsPage.class);
    }
}
