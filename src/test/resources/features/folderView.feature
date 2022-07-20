Feature: Folder View Functionality [AutomationS4]
  As a user, I should be able to change folder view order by using Name/Size/Modified buttons

  Background:
    Given User goes to login page
    When User enters "Employee91" username
    And User enters "Employee123" password
    And User clicks on login button
    Then User should be logged in

  @MTSK-493
  Scenario: User can change folder view order by Name
    Given User clicks Name link
    Then User sees Files and Folders in an order according to their Names

  @MTSK-494
  Scenario: User can change folder view order by Size
    Given User clicks Size link
    Then User sees Files and Folders in an order according to their Size
