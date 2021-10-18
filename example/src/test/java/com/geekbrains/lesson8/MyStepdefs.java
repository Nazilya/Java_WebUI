package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("I am authorized")
    public void iAmAuthorized() {
        new LoginPage().login("applanatest1", "Student2020!");
    }

    @And("^i select business unit$")
    public void iSelectBusinessUnit() {
        new CreateExpensePage().selectBusinessUnit("Research & Development");
    }

    @And("^i select expenditure$")
    public void iSelectExpenditure() {
        new CreateExpensePage().selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры");
    }

    @And("^i select currency$")
    public void iSelectCurrency() {
        new CreateExpensePage().selectCurrency("Доллар США");
    }

    @And("^i fill sum plan$")
    public void iFillSumPlan() {
        new CreateExpensePage().fillSumPlanInput("15");
    }

    @And("^i fill data$")
    public void iFillData() {
        new CreateExpensePage().selectPlannedDate("15");
    }

    @And("^i click save and close button$")
    public void iClickSaveAndCloseButton() {
        new CreateExpensePage().saveAndCloseButtonClick();
    }

    @Then("^i can see success message$")
    public void iCanSeeSuccessMessage() {
        new CreateExpensePage().expenseRequestCreationSuccessful.shouldBe(Condition.visible);
    }

    @Given("i hover expenses menu")
    public void iHoverExpensesMenu() {
        new MainPage().navigationMenu.openNavigationSubMenuItems("Расходы");
    }

    @And("i click all expenses button")
    public void iClickAllExpensesButton() {
        new ExpensesSubMenu().expensesButtonClick();
    }

    @And("i click create expense button")
    public void iClickCreateExpenseButton() {

        new ExpensesPage().createExpenseButtonClick();
    }

    @When("i fill field expense appointment with {string}")
    public void iFillFieldExpenseAppointmentWithName(String name) {
        new CreateExpensePage().fillExpenseAppointment(name);
    }
}