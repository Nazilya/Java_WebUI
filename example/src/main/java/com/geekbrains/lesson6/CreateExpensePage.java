package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateExpensePage extends BaseView {
    public CreateExpensePage(WebDriver webDriver) {
        super(webDriver);
    }

    final static String expenseAppointmentCssLocator = "textarea";
    @FindBy(css = expenseAppointmentCssLocator)
    public WebElement expenseAppointment;

    @Step("Заполнить поле appointment")
    public CreateExpensePage fillExpenseAppointment(String appointment) {
        expenseAppointment.sendKeys(appointment);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_expense_request[businessUnit]']")
    public WebElement businessUnitSelect;

    @Step("Выбрать BusinessUnit")
    public CreateExpensePage selectBusinessUnit(String option) {
        new Select(businessUnitSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_expense_request[expenditure]']")
    public WebElement expenditureSelect;

    @Step("Выбрать Expenditure")
    public CreateExpensePage selectExpenditure(String option) {
        new Select(expenditureSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_expense_request[currency]']")
    public WebElement currencySelect;

    @Step("Выбрать Currency")
    public CreateExpensePage selectCurrency(String option) {
        new Select(currencySelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//button[contains(., 'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @Step("Клик на кнопку Сохранить и закрыть")
    public CreateExpensePage saveAndCloseButtonClick() {
        saveAndCloseButton.click();
        return this;
    }

    @FindBy(name = "crm_expense_request[sumPlan]")
    public WebElement sumPlanInput;

    @Step("Заполнить сумму")
    public CreateExpensePage fillSumPlanInput(String sum) {
        sumPlanInput.sendKeys(sum);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]")
    public WebElement plannedDateInput;

    @FindBy(xpath = "//td[@data-handler='selectDay']")
    public List<WebElement> plannedDates;

    @Step("Выбрать планируемую дату")
    public CreateExpensePage selectPlannedDate(String dayNumber) {
        plannedDateInput.click();
        plannedDates.stream().filter(element -> element.getText().equals(dayNumber)).findFirst().get().click();
        return this;
    }
}