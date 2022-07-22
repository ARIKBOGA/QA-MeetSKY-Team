@wip
Feature:Calendar Module Functionality
  User Story: As a user, I should be able to see daily-weekly-monthly calendar view
              and create a new event under the calendar module
  Background:
    Given User goes to login page
    When User enters "Employee1" and "Employee123" and clicks on login button
    Then User should be logged in


  Scenario:
    When User clicks on calendar page link
    And User clicks on action item and then daily action button
    Then User should be display daily calendar view

  Scenario:
    When User clicks on action item  and weekly action button
    Then User should be display weekly calendar view

  Scenario:
    When User clicks on action item and monthly action button
    Then User should be display monthly calendar view

    Scenario:
     When User clicks on new event button on the left side





