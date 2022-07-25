
Feature:Calendar Module Functionality
  User Story: As a user, I should be able to see daily-weekly-monthly calendar view
              and create a new event under the calendar module
  Background:
    Given User goes to login page
    When User enters "Employee1" and "Employee123" and clicks on login button
    Then User should be logged in
  Scenario: User can display daily calendar view
    Given User clicks on calendar page link
    And User clicks on action item and then daily action button
    Then User should be display daily calendar view

  Scenario: User can display weekly calendar view
    Given User clicks on calendar page link
    When User clicks on action item  and weekly action button
    Then User should be display weekly calendar view

  Scenario: User can display monthly calendar view
    Given User clicks on calendar page link
    When User clicks on action item and monthly action button
    Then User should be display monthly calendar view
@wip
  Scenario Outline: User can create new event under the calendar module and see it on the related day
             through the monthly calendar view
    Given User clicks on calendar page link
     When User clicks on new event button on the left side
     And  User types "<title>", "<startDate>", "<endDate>"  as event
     Then User should be able to create new event
    Examples:
    |title           | startDate                | endDate               |
    |vacation        | from 30/07/2022          | to 31/07/2022         |
    |sprint planning | from 15/08/2022 at 14:00 | to 15/08/2022 at 15:00|
    |report date     | from 01/01/2023 at 08:00 | to 01/01/2023 at 12:00|





