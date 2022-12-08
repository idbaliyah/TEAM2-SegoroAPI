Feature: Get All Users that request to be owner
  @user
  Scenario: Get all user request to be owner
    Given Get All users valid parameter
    When Send get all users to owner request
    Then Status code should be 200 OK
    And Validate get all users request json schema validator