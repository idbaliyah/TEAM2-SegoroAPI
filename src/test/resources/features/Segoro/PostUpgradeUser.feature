Feature: Upgrade User To Owner Feature Test
  @user @upgrade
  Scenario: Post upgrade user to owner valid data
    Given Post upgrade user to owner
    When Send post upgrade user request
    Then Status code should be 200 OK