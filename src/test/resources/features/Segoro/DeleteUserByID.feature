Feature: Delete User Feature Test
  @user
  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send delete user request
    Then Status code should be 200 OK
    Examples:
      | id |
      | 4  |