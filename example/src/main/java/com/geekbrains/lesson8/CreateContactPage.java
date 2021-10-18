package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CreateContactPage {

    private SelenideElement contactLastName = $(By.xpath("//input[@name='crm_contact[lastName]']"));
    @Step("Заполнить поле lastName")
    public CreateContactPage fillContactLastName(String lastName) {
        contactLastName.sendKeys(lastName);
        return this;
    }
    private SelenideElement fillContactFirstName = $(By.xpath("//input[contains(@id,'crm_contact_firstName-uid')]"));
    @Step("Заполнить поле firstName")
    public CreateContactPage fillContactFirstNameClick(String firstName) {
        fillContactFirstName.sendKeys(firstName);
        return this;
    }
    private SelenideElement contactOrganization = $(By.xpath("//span[text()='Укажите организацию']"));
    @Step("Нажать на поле Укажите организацию")
    public CreateContactPage contactOrganizationClick() {
        contactOrganization.click();
        return this;
    }
    private SelenideElement contactOrganizationType = $(By.xpath("//div[text()='Bins-Haley']"));
    @Step("Выбрать организацию")
    public CreateContactPage contactOrganizationTypeClick() {
        contactOrganizationType.click();
        return this;
    }
    private SelenideElement contactJob = $(By.xpath("//input[@name='crm_contact[jobTitle]']"));
    @Step("Заполнить поле jobTitle")
    public CreateContactPage fillContactJobTitle(String jobTitle) {
        contactJob.sendKeys(jobTitle);
        return this;
    }
    private SelenideElement contactSaveAndCloseButton = $(By.xpath("//button[contains(., 'Сохранить и закрыть')]"));
    @Step("Клик на кнопку Сохранить и закрыть")
    public CreateContactPage contactSaveAndCloseButtonClick(){
        contactSaveAndCloseButton.click();
        return this;
    }
    public SelenideElement contactCreationSuccessful = $(By.xpath("//div[.='Контактное лицо сохранено']"));
}