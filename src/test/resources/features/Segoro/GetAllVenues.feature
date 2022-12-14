#Feature: Get Venue By User ID test
#  @venue
#  Scenario Outline: Get Venue By valid user <id>
#    Given Get venue with parameter user <id>
#    When Send get all venue request
#    Then Status code should be 200 OK
#    And Response body page user <id>
#    And Validate all venues json schema
#    Examples:
#      | id |
#      | 1  |
#      | 2  |

Feature: Get All Venues
  @venueAll
  Scenario: Get all venues
    Given Get All venue valid parameter
    When Send get all venue request
    Then Status code should be 200 OK
    And Validate get all venue json schema validator


















