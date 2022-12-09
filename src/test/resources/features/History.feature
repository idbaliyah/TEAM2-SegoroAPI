@Test @History
Feature: History
  Scenario Outline: Get history valid ID
    Given get history valid id <id>
    When send get history id request
    Then status code is 200 OK
    And validate get history id json schema validator
    Examples:
      | id |
      | 45 |

  Scenario Outline: Get history invalid ID
    Given get history invalid id <id>
    When send get history id request
    Then status code is 200 OK
    And validate get history invalid id json schema validator
    Examples:
      | id |
      | 34 |
