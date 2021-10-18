package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateProjectPage {
    private SelenideElement projectName = $(By.xpath("//input[contains(@id,'crm_project_name')]"));

    @Step("Заполнить поле crm_project_name")
    public CreateProjectPage fillprojectName(String name) {
        projectName.sendKeys(name);
        return this;
    }

    private SelenideElement organization = $(By.xpath("//span[text()='Укажите организацию']"));
    @Step("Нажать на поле Укажите организацию")
    public CreateProjectPage organizationClick() {
        organization.click();
        return this;
    }

    private SelenideElement organizationType = $(By.xpath("//div[text()='«Все организации»']"));
    @Step("Выбрать организацию")
    public CreateProjectPage organizationTypeClick() {
        organizationType.click();
        return this;
    }
    private SelenideElement prioritySelect = $(By.xpath("//select[@name='crm_project[priority]']"));
    @Step("Выбрать priority")
    public CreateProjectPage selectPriority(String option) {
        prioritySelect.selectOptionContainingText(option);
        return this;
    }
    private SelenideElement financeSourceSelect = $(By.xpath("//select[@name='crm_project[financeSource]']"));
    @Step("Выбрать financeSource")
    public CreateProjectPage selectFinanceSource(String option) {
        financeSourceSelect.selectOptionContainingText(option);
        return this;
    }
    private SelenideElement businessUnitSelect = $(By.xpath("//select[@name='crm_project[businessUnit]']"));
    @Step("Выбрать businessUnit")
    public CreateProjectPage selectBusinessUnit(String option) {
        businessUnitSelect.selectOptionContainingText(option);
        return this;
    }
    private SelenideElement curatorSelect = $(By.xpath("//select[@name='crm_project[curator]']"));
    @Step("Выбрать curator")
    public CreateProjectPage selectCurator(String option) {
        curatorSelect.selectOptionContainingText(option);
        return this;
    }
    private SelenideElement rpSelect = $(By.xpath("//select[@name='crm_project[rp]']"));
    @Step("Выбрать rp")
    public CreateProjectPage selectRp(String option) {
        rpSelect.selectOptionContainingText(option);
        return this;
    }
    private SelenideElement administratorSelect = $(By.xpath("//select[@name='crm_project[administrator]']"));
    @Step("Выбрать administrator")
    public CreateProjectPage selectAdministrator(String option) {
        administratorSelect.selectOptionContainingText(option);
        return this;
    }
    private SelenideElement managerSelect = $(By.xpath("//select[@name='crm_project[manager]']"));
    @Step("Выбрать manager")
    public CreateProjectPage selectManager(String option) {
        managerSelect.selectOptionContainingText(option);
        return this;
    }
    private SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(text(),'Сохранить и закрыть')]"));
    @Step("Клик на кнопку Сохранить и закрыть")
    public CreateProjectPage iClickSaveAndCloseProjectButton(){
        saveAndCloseButton.click();
        return this;
    }
    public SelenideElement projectCreationUnsuccessful = $(By.xpath("//span[.='Это значение уже используется.']"));
}
