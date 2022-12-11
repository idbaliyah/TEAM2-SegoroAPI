Feature: Get All Data Fields Test
  @fields
  Scenario: Get All Data Fields
    Given Get all data field with valid parameter
    When Send all data field request
    Then Status code should be 200 OK
    And Validate all data fields json schema validator