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
    And User clicks on action item button
    Then User should be display daily calendar view


