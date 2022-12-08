Feature: Get All Users
  @user @getAllUser
  Scenario: Get all users
    Given Get all users with valid parameter
    When Send get all users request
    Then Status code should be 200 OK
    And Validate get all users json schema validator
