Feature: Get Review By Venue ID Test
  @review
  Scenario Outline: Get review with valid venue ID
    Given Get review with Venue <id>
    When Send get review request
    Then Status code should be 200 OK
    And Validate review with json schema
    Examples:
      | id |
      | 1  |