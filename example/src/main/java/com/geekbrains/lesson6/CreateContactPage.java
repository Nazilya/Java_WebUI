package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContactPage extends BaseView {
    public CreateContactPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = contactLastNameXpathLocator)
    public WebElement contactLastName;
    @Step("Заполнить поле lastName")
    public CreateContactPage fillContactLastName(String lastName) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(contactLastNameXpathLocator)));
        contactLastName.sendKeys(lastName);
        return this;
    }
    final static String contactLastNameXpathLocator = "//input[@name='crm_contact[lastName]']";

    @FindBy(xpath = contactFirstNameXpathLocator)
    public WebElement fillContactFirstName;
    @Step("Заполнить поле firstName")
    public CreateContactPage fillContactFirstNameClick(String firstName) {
        fillContactFirstName.sendKeys(firstName);
        return this;
    }
    final static String contactFirstNameXpathLocator = "//input[contains(@id,'crm_contact_firstName-uid')]";

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement contactOrganization;
    @Step("Нажать на поле Укажите организацию")
    public CreateContactPage contactOrganizationClick() {
        contactOrganization.click();
        return this;
    }

    @FindBy(xpath = contactOrganizationTypeXpathLocator)
    public WebElement contactOrganizationType;
    @Step("Выбрать организацию")
    public CreateContactPage contactOrganizationTypeClick() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(contactOrganizationTypeXpathLocator)));
        contactOrganizationType.click();
        return this;
    }
    final static String contactOrganizationTypeXpathLocator = "//div[text()='Bins-Haley']";
    
    @FindBy(xpath = contactJobTitleXpathLocator)
    public WebElement contactJob;
    @Step("Заполнить поле jobTitle")
    public CreateContactPage fillContactJobTitle(String jobTitle) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(contactJobTitleXpathLocator)));
        contactJob.sendKeys(jobTitle);
        return this;
    }
    final static String contactJobTitleXpathLocator = "//input[@name='crm_contact[jobTitle]']";


    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement contactSaveAndCloseButton;
    @Step("Клик на кнопку Сохранить и закрыть")
    public CreateContactPage contactSaveAndCloseButtonClick(){
        contactSaveAndCloseButton.click();
        return this;
    }
}
/*

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
 */