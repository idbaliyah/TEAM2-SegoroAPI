Feature: Get Venue By ID test
  @venue
    Scenario Outline: Get single Venue By ID with valid Venue <id>
      Given Get single venue with parameter venue <id>
      When Send get single venue request
      Then Status code should be 200 OK
      And Response body page venue be <id>
      And Validate single venue json schema
    Examples:
      | id |
      | 1  |