package com.geekbrains.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Story("Создание контактного лица")

public class CreateContactTest extends BaseTest {
    @BeforeEach
    void setupBrowser2() {
        webDriver.get("https://crm.geekbrains.space/");
    }
    @Test
    void createContactTest() {
        new LoginPage(webDriver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin()
                .navigationMenu.openNavigationSubMenuItems("Контрагенты");
        new ContactsSubMenu(webDriver).contactsButtonClick().createContactButtonClick();
        new CreateContactPage(webDriver)
                .fillContactLastName("Фамилия")
                .fillContactFirstNameClick("Имя")
                .contactOrganizationClick()
                .contactOrganizationTypeClick()
                .fillContactJobTitle("Директор")
                .contactSaveAndCloseButtonClick();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Контактное лицо сохранено']")));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//div[.='Контактное лицо сохранено']")).isDisplayed());

    }
}
