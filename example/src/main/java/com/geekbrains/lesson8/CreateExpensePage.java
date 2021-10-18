package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateExpensePage {

    private SelenideElement expenseAppointment = $(By.cssSelector("textarea"));

    @Step("Заполнить поле appointment")
    public CreateExpensePage fillExpenseAppointment(String appointment) {
        expenseAppointment.sendKeys(appointment);
        return this;
    }

    public SelenideElement businessUnitSelect = $(By.xpath("//select[@name='crm_expense_request[businessUnit]']"));

    @Step("Выбрать BusinessUnit")
    public CreateExpensePage selectBusinessUnit(String option) {
        businessUnitSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement expenditureSelect = $(By.xpath("//select[@name='crm_expense_request[expenditure]']"));

    @Step("Выбрать Expenditure")
    public CreateExpensePage selectExpenditure(String option) {
        expenditureSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement currencySelect = $(By.xpath("//select[@name='crm_expense_request[currency]']"));

    @Step("Выбрать Currency")
    public CreateExpensePage selectCurrency(String option) {
        currencySelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(., 'Сохранить и закрыть')]"));

    @Step("Клик на кнопку Сохранить и закрыть")
    public CreateExpensePage saveAndCloseButtonClick() {
        saveAndCloseButton.click();
        return this;
    }

    private SelenideElement sumPlanInput = $(By.name("crm_expense_request[sumPlan]"));

    @Step("Заполнить сумму")
    public CreateExpensePage fillSumPlanInput(String sum) {
        sumPlanInput.sendKeys(sum);
        return this;
    }

    private SelenideElement plannedDateInput = $(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]"));

    private List<SelenideElement> plannedDates = $$(By.xpath("//td[@data-handler='selectDay']"));

    @Step("Выбрать планируемую дату")
    public CreateExpensePage selectPlannedDate(String dayNumber) {
        plannedDateInput.click();
        plannedDates.stream().filter(element -> element.getText().equals(dayNumber)).findFirst().get().click();
        return this;
    }

    public SelenideElement expenseRequestCreationSuccessful = $(By.xpath("//*[.='Заявка на расход сохранена']"));
}