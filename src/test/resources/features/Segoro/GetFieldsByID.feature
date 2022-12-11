Feature: Get Field By ID test
  @fields
  Scenario Outline: Get single field with valid id
    Given Get single field with valid <id>
    When Send get single field request
    Then Status code should be 200 OK
    And Validate get single field json schema
    Examples:
      | id |
      | 18 |