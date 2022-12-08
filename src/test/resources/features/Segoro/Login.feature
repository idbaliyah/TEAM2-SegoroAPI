Feature: Login User

  @login @admin
  Scenario: Login User Admin with valid data
    Given Post login admin with valid json
    When Send post login user request
    Then Status code should be 200 OK
    And Response body should contain "admin" as role
    And Validate login with json schema

  @login @owner
    Scenario: Login User Owner with valid data
      Given Post login user owner with valid json
      When Send post login user request
      Then Status code should be 200 OK
      And Response body should contain "user" as role
      And Validate login with json schema

  @login @user
  Scenario: Login User with valid data
    Given Post login user with valid json
    When Send post login user request
    Then Status code should be 200 OK
    And Response body should contain "user" as role
    And Validate login with json schema