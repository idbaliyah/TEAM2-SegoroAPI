Feature: Create User Feature Test
  @user @create
  Scenario: Post create new user with valid data
    Given Post create user with valid data
    When Send post user request
    Then Status code should be 200 OK