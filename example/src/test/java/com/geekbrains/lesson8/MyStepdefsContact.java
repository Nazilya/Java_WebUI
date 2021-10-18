package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefsContact {
    @Given("I am authorized for createContact")
    public void iAmAuthorizedForCreateContact() {
        new LoginPage().login("applanatest1", "Student2020!");
    }

    @Given("i hover contact menu")
    public void iHoverContactMenu() {

        new MainPage().navigationMenu.openNavigationSubMenuItems("Контрагенты");
    }

    @And("i click all contacts button")
    public void iClickAllContactsButton() {
        new ContactsSubMenu().contactsButtonClick();
    }

    @And("i click create contacts button")
    public void iClickCreateContactsButton() {
        new ContactsPage().createContactButtonClick();
    }

    @When("i fill LastName with {string}")
    public void iFillLastNameWithLastName(String lastName) {
        new CreateContactPage().fillContactLastName(lastName);
    }

    @And("i fill FirstName with {string}")
    public void iFillFirstNameWithFirstName(String firstName) {
        new CreateContactPage().fillContactFirstNameClick(firstName);
    }

    @And("i click contactOrganizationField")
    public void iClickContactOrganizationField() {
        new CreateContactPage().contactOrganizationClick();
    }

    @And("i click contactOrganizationType")
    public void iClickContactOrganizationType() {
        new CreateContactPage().contactOrganizationTypeClick();
    }

    @And("i fill contactJob")
    public void iFillContactJobWithJobTitle() {
        new CreateContactPage().fillContactJobTitle("Директор");
    }

    @And("i click save and close contactButton")
    public void iClickSaveAndCloseContactButton() {
        new CreateContactPage().contactSaveAndCloseButtonClick();
    }

    @Then("i can see success contactMessage")
    public void iCanSeeSuccessContactMessage() {
        new CreateContactPage().contactCreationSuccessful.shouldBe(Condition.visible);
    }

}
