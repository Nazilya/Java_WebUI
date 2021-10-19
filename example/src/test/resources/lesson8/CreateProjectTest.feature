Feature: create project request

  Background:
    Given I am authorized for createProject

  Scenario Outline:
    Given i hover project menu
    And i click all projects button
    And i click create project button
    When i fill field projectName with '<name>'
    And i click organizationField
    And i click organization type
    And i select priority
    And i select finance source
    And i select business Unit
    And i select curator
    And i select rp
    And i select administrator
    And i select manager
    And i click save and close projectButton
    Then i can see unsuccess message

    Examples:
      | name  |
      | test1  |
