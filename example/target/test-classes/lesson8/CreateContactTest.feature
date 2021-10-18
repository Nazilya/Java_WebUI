Feature: create contact request

  Background:
    Given I am authorized for createContact

  Scenario Outline:
    Given i hover contact menu
    And i click all contacts button
    And i click create contacts button
    When i fill LastName with '<lastName>'
    And i fill FirstName with '<firstName>'
    And i click contactOrganizationField
    And i click contactOrganizationType
    And i fill contactJob
    And i click save and close contactButton
    Then i can see success contactMessage
    Examples:
      | lastName  | firstName |
      | Фамилия   | Имя       |
