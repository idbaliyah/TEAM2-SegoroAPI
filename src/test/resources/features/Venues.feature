@Test @Venues
Feature: Venues

  Scenario: Post venues
    Given create new venues with body
    When send post create venues request
    Then status code is 200 OK
    And response body should status "Success"
    And validate create venue json schema validator

  Scenario Outline: Delete venues valid ID
    Given delete venues valid id <id>
    When send delete venues request
    Then status code is 200 OK
    And validate delete venue json schema validator
    Examples:
      | id |
      | 3  |


























