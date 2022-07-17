@MTSK-491 @Regression
Feature: As a user, I should be able to create a new contact and edit/delete any contact under Contacts module

  Background: User logs in
    Given User goes to login page
    And User logs in with valid credentials
    Then User goes to Contacts page

  @MTSK-487 @Smoke
  Scenario: User can create a new contact with valid inputs
    Given User fills all properties out

  @MTSK-488
  Scenario: User can see all the contacts as a list inside the middle column and
  total number of the contacts near the “All Contacts” tab

  @MTSK-489
  Scenario: User can change the profile picture of any contact with a
  previously uploaded picture by using “Choose from files” option

  @MTSK-490 @Smoke
  Scenario: User can delete any selected contact