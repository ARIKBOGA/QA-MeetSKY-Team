Feature: As a user, I should be able to create/delete conversation groups and chat with other co-workers under Talk Module

  Background: User logs in
    Given User goes to login page
    And User logs in with valid credentials
    Then User goes to Talk page


  Scenario: User can create a new group conversation by adding other users
    Given User clicks to plus sign on the left side of the page
    And User enters the {work chat} conversation name
    Then User clicks "Add Participants" button
    And User user chooses any of the contacts from the contacts list
    And User clicks "Create Conversetion" button
    Then User verify {work chat} has created

  Scenario: User can see the participants of the conversation on the right-hand menu under Participants
    Given User clicks to {work chat} group on the left side of the page
    Then User verify that he/she can see the participants of the group conversation under Participants tab


  Scenario: User can remove any participant from the conversation as being moderator of the conversation
    Given User clicks to {work chat} group on the left side of the page
    Then User locates the participants of the group conversation under Participants tab
    And User clicks to the three dots next to participant name
    And User clicks to the "Remove participant" button
    Then User verify the participant has been succesfully removed from the group


  Scenario: User can send messages by typing inside the inputbox at the bottom of the middle screen on Talk Module page
    Given User clicks to {work chat} group on the left side of the page
    Then User clicks to  inputbox at the bottom of the middle screen
    And User types message to the inputbox and clicks enter button
    Then User verify the message is displayed on the chat screen and one tick sign is visible right next to time stamp on the message


  Scenario: User can delete any group conversation previously created
    Given User clicks to three dots on the right side of the {work chat}
    Then User clicks to the "Delete conversation" button
    And User cliks to "Yes" button on the pop-up asking "Do you really want to delete "work chat"?"
    Then User verify that deleted group conversation is not existing inside the available group conversations










