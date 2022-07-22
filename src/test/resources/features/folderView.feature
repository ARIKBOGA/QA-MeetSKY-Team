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
    Given User toggles list view
    When User clicks Name link
    And User scrolls to button of page to load all items
    Then User sees Files and Folders in an order according to their Names

  @MTSK-494
  Scenario: User can change folder view order by Size
    Given User toggles list view
    When User clicks Size link
    And User scrolls to button of page to load all items
    Then User sees Files and Folders in an order according to their Size

    Scenario: User can change folder view order by Modified
      Given User toggles list view
      When User clicks Modified link
      And User scrolls to button of page to load all items
      Then User sees Files and Folders in an order according to Modified day
