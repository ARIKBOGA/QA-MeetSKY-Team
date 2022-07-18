Feature: As a user, I should be able to add a file to favorites, rename any file and give some comments on any file.
  #  User Story :
# # As a user, I should be able to add a file to favorites, rename any file and give some comments on any file.
  # Acceptance Criteria:
#  User can add any file to favorites from its own three dots menu
#  User can rename any file from its own three dots menu
#  User can put some comments on any file from the file details menu opened right side
#  User can delete the comments made on any file from the the file details menu opened rigth side

  Background: user clicks on "Files" button on top header menu

  Scenario: User can add any file to favorites from its own three dots menu
    And user click on the three dots next to any file
    And user clicks on Add to favorites button
    And user clicks on Favorites tab at the left menu
    Then user can see that the file is listed at the Favorites tab


# User can rename any file from its own three dots menu
  Scenario: User can rename any file from its own three dots menu
    And user click on the three dots next to any file
    And user clicks on Rename button
    And user enters new name to rename the chosen file
    Then user can see the file name as the typed one

#User can put some comments on any file from the file details menu opened right side

  Scenario: User can put some comments on any file from the file details menu opened right side
    And user clicks on the three dots next to any file
    And user clicks on Details button
    And user clicks on Comments button
    And user clicks on text filed and types some comments and press enters key
    Then user can see that the comment is posted

# User can delete the comments made on any file from the the file details menu opened rigth side

  Scenario: User can delete the comments made on any file from the the file details menu opened rigth side
    And user clicks on the three dots just above the comment
    And user clicks on Details button
    And user clicks on Comments button
    And user clicks on "Delete comment" button
    Then user can see that the comment is deleted