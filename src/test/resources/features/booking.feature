#@Test @Booking
#Feature: Booking
#
#  Scenario: Get all bookings invalid URL
#    Given get all bookings invalid URL
#    And send all bookings request
#    Then API should return response 404 not found
#
#  Scenario: Get all bookings
#    Given get all bookings
#    And send all bookings request
#    Then Status code is 200 OK
#    And Validate get all projects json schema validator
#
#  Scenario Outline: Get booking invalid user ID
#  Scenario Outline: Get booking by user ID
#  Scenario: Add booking to cart
#  Scenario Outline: Add payment valid ID
#  Scenario Outline: Add payment invalid ID
#  Scenario Outline: Delete booking cart valid ID
#  Scenario Outline: Delete booking cart invalid ID