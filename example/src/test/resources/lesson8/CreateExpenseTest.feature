 #Language: ru

 Feature: create expense request

   Background:
     Given I am authorized

   Scenario Outline:
     Given i hover expenses menu
     And i click all expenses button
     And i click create expense button
     When i fill field expense appointment with '<name>'
     And i select business unit
     And i select expenditure
     And i select currency
     And i fill sum plan
     And i fill data
     And i click save and close button
     Then i can see success message

     Examples:
       | name  |
       | test  |
