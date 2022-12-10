@Test @Booking
Feature: Booking

  Scenario: Get all bookings invalid URL
    Given get all bookings invalid URL
    When send all bookings invalid URL request
    Then status code is 404 not found

  Scenario: Get all bookings
    Given get all bookings
    When send all bookings request
    Then status code is 200 OK
    And validate get all bookings json schema validator

  Scenario Outline: Get booking invalid user ID
    Given get booking invalid id <id>
    When send get booking id request
    Then status code is 200 OK
    And validate get all bookings json schema validator
    Examples:
      | id  |
      | 135 |

  Scenario Outline: Get booking by user ID
    Given get booking id <id>
    When send get booking id request
    Then status code is 200 OK
    And validate get all bookings json schema validator
    Examples:
      | id |
      | 35 |

  Scenario: Add booking to cart
    Given add booking to cart
    When send add booking request
    Then status code is 200 OK
    And validate add booking json schema validator

  Scenario Outline: Add payment valid ID
    Given add payment valid id <id>
    When send add payment request
    Then status code is 505 OK
    Examples:
      | id |
      | 4  |

  Scenario Outline: Delete booking cart valid ID
    Given delete booking valid id <id>
    When send delete booking request
    Then status code is 200 OK
    Examples:
      | id |
      | 35 |
