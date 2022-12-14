Feature: Update User Feature Test
  @user @update
  Scenario: Put update new user with valid data
    Given Put update user with valid data
    When Send put user request
    Then Status code should be 200 OK