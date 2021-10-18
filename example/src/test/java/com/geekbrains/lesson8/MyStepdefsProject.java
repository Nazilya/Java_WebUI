package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefsProject {

    @Given("I am authorized for createProject")
    public void iAmAuthorized() {

        new LoginPage().login("applanatest1", "Student2020!");
    }

    @Given("i hover project menu")
    public void iHoverProjectMenu() {

        new MainPage().navigationMenu.openNavigationSubMenuItems("Проекты");
    }
    @And("i click all projects button")
    public void iClickAllProjectsButton() {

        new ProjectsSubMenu().projectsButtonClick();
    }
    @And("i click create project button")
    public void iClickCreateProjectButton() {

        new ProjectsPage().createProjectButtonClick();
    }
    @When("i fill field projectName with {string}")
    public void iFillFieldProjectNameWithName(String name) {

        new CreateProjectPage().fillprojectName(name);
    }
    @And("i click organizationField")
    public void iClickOrganizationField() {

        new CreateProjectPage().organizationClick();
    }
    @And("i click organization type")
    public void iClickOrganizationType() {
        new CreateProjectPage().organizationTypeClick();
    }
    @And("i select priority")
    public void iSelectPriority() {
        new CreateProjectPage().selectPriority("Высокий");
    }
    @And("i select finance source")
    public void iSelectFinanceSource() {
        new CreateProjectPage().selectFinanceSource("Инвестиции");
    }
    @And("i select business Unit")
    public void iSelectBusinessUnit() {
        new CreateProjectPage().selectBusinessUnit("Research & Development");
    }
    @And("i select curator")
    public void iSelectCurator() {
        new CreateProjectPage().selectCurator("Скоробогатова Юлия");
    }
    @And("i select rp")
    public void iSelectRp() {
        new CreateProjectPage().selectRp("Зайдуллин Рустам");
    }
    @And("i select administrator")
    public void iSelectAdministrator() {
        new CreateProjectPage().selectAdministrator("Горячев Алексей");
    }
    @And("i select manager")
    public void iSelectManager() {
        new CreateProjectPage().selectManager("Исаева Анастасия");
    }
    @And("i click save and close projectButton")
    public void iClickSaveAndCloseProjectButton() {
        new CreateProjectPage().iClickSaveAndCloseProjectButton();
    }
    @Then("i can see unsuccess message")
    public void iCanSeeUnsuccessMessage() {
        new CreateProjectPage().projectCreationUnsuccessful.shouldBe(Condition.visible);
    }
}
/*
    @Then("^i can see success message$")
    public void iCanSeeSuccessMessage() {
        new CreateExpensePage().expenseRequestCreationSuccessful.shouldBe(Condition.visible);
    }
 */
