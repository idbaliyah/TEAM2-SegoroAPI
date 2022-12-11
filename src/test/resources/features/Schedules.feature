@Test @Schedules
Feature: Schedules
  Scenario: Post schedules
    Given create new schedules with body
    When send post create schedules request
    Then status code is 200 OK
    And response body should status "Success"
    And validate create schedule json schema validator

  Scenario: Get all schedules
    Given get all schedules
    When send all schedules request
    Then status code is 200 OK
    And validate get all schedules json schema validator

  Scenario Outline: Get schedules invalid ID
    Given get schedules invalid id <id>
    When send get schedules request
    Then status code is 500 OK
    And validate get schedules id json schema validator
    Examples:
      | id |
      | 20 |

  Scenario Outline: Get schedule valid ID
    Given get schedule valid id <id>
    When send get schedule request
    Then status code is 200 OK
    And validate get schedules id json schema validator
    Examples:
      | id |
      | 16 |

  Scenario Outline: Get schedule invalid field ID
    Given get schedule field id <id>
    When send get schedule request
    Then status code is 200 OK
    And validate get schedules field id json schema validator
    Examples:
      | id |
      | 20 |

  Scenario Outline: Get schedule valid field ID
    Given get schedule invalid field id <id>
    When send get schedule request
    Then status code is 200 OK
    And validate get schedules field id json schema validator
    Examples:
      | id |
      | 18 |

  Scenario Outline: Put schedule valid ID
    Given update schedule id <id>
    When send update schedule request
    Then status code is 500 OK
    And validate update schedule id json schema validator
    Examples:
      | id |
      | 16 |

  Scenario Outline: Delete schedule invalid ID
    Given delete schedule invalid id <id>
    When send delete schedule request
    Then status code is 500 OK
    And validate delete schedule id json schema validator
    Examples:
      | id |
      | 17 |

  Scenario Outline: Delete schedule valid ID
    Given delete schedule valid id <id>
    When send delete schedule request
    Then status code is 200 OK
    And validate delete schedule id json schema validator
    Examples:
      | id |
      | 24 |
