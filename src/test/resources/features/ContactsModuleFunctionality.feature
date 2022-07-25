@MTSK-491 @Regression
Feature: As a user, I should be able to create a new contact and edit/delete any contact under Contacts module

  Background: User logs in
    Given User goes to login page
    And User logs in with valid credentials
    Then User goes to Contacts page

  @MTSK-487
  Scenario Outline: User can create a new contact with all properties filled with valid inputs
    Given User clicks to new contact button
    And User fills "<Full name>" "<Company>" "<Title>" "<Phone>" "<Email>" "<City>" "<Country>" properties out
    Then User clicks to All contacts link
    Examples:
      | Full name     | Company | Title | Phone      | Email             | City   | Country |
      | Didier Drogba | Cydeo   | QA    | 8764756387 | ddrogba@gmail.com | London | England |

  @MTSK-488
  Scenario: User can see all the contacts as a list inside the middle column and
  total number of the contacts near the “All Contacts” tab
    Given User clicks to All contacts link
    Then User should be able to see all contacts in the middle column
    Then User should be able to se the correct number near the “All Contacts” tab

  @MTSK-489
  Scenario: User can change the profile picture of any contact with a
  previously uploaded picture by using “Choose from files” option
    Given User clicks to All contacts link
    And User clicks to a random contact in the middle column
    And User clicks to Change Picture button
    And User clicks to Choose From File button
    And User selects a jpeg file by clicking
    And User clicks to Choose button
    Then User should be able to see the PP has been changed

  @MTSK-490
  Scenario: User can delete any selected contact
    Given User clicks to All contacts link
    And User clicks to a random contact in the middle column
    And User clicks to Three dot menu link
    And User clicks to Delete button
    Then User should be able to see the contact has been deleted