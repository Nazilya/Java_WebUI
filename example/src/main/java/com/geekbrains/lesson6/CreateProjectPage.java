package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseView {
    public CreateProjectPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = projectNameXpathLocator)
    public WebElement projectName;
    @Step("Заполнить поле crm_project_name")
    public CreateProjectPage fillprojectName(String name) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(projectNameXpathLocator)));
        projectName.sendKeys(name);
        return this;
    }
    final static String projectNameXpathLocator = "//input[contains(@id,'crm_project_name')]";

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement organization;
    @Step("Нажать на поле Укажите организацию")
    public CreateProjectPage organizationClick() {
        organization.click();
        return this;
    }
    @FindBy(xpath = organizationTypeXpathLocator)
    public WebElement organizationType;
    @Step("Выбрать организацию")
    public CreateProjectPage organizationTypeClick() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(organizationTypeXpathLocator)));
        organizationType.click();
        return this;
    }
    final static String organizationTypeXpathLocator = "//div[text()='«Все организации»']";

    @FindBy(xpath = "//select[@name='crm_project[priority]']")
    public WebElement prioritySelect;
    @Step("Выбрать priority")
    public CreateProjectPage selectPriority(String option) {
        new Select(prioritySelect).selectByVisibleText(option);
        return this;
    }
    @FindBy(xpath = "//select[@name='crm_project[financeSource]']")
    public WebElement financeSourceSelect;
    @Step("Выбрать financeSource")
    public CreateProjectPage selectFinanceSource(String option) {
        new Select(financeSourceSelect).selectByVisibleText(option);
        return this;
    }
    @FindBy(xpath = "//select[@name='crm_project[businessUnit]']")
    public WebElement businessUnitSelect;
    @Step("Выбрать businessUnit")
    public CreateProjectPage selectBusinessUnit(String option) {
        new Select(businessUnitSelect).selectByVisibleText(option);
        return this;
    }
    @FindBy(xpath = "//select[@name='crm_project[curator]']")
    public WebElement curatorSelect;
    @Step("Выбрать curator")
    public CreateProjectPage selectCurator(String option) {
        new Select(curatorSelect).selectByVisibleText(option);
        return this;
    }
    @FindBy(xpath = "//select[@name='crm_project[rp]']")
    public WebElement rpSelect;
    @Step("Выбрать rp")
    public CreateProjectPage selectRp(String option) {
        new Select(rpSelect).selectByVisibleText(option);
        return this;
    }
    @FindBy(xpath = "//select[@name='crm_project[administrator]']")
    public WebElement administratorSelect;
    @Step("Выбрать administrator")
    public CreateProjectPage selectAdministrator(String option) {
        new Select(administratorSelect).selectByVisibleText(option);
        return this;
    }
    @FindBy(xpath = "//select[@name='crm_project[manager]']")
    public WebElement managerSelect;
    @Step("Выбрать manager")
    public CreateProjectPage selectManager(String option) {
        new Select(managerSelect).selectByVisibleText(option);
        return this;
    }
    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;
    @Step("Клик на кнопку Сохранить и закрыть")
    public CreateProjectPage saveAndCloseButtonClick(){
        saveAndCloseButton.click();
        return this;
    }
}
