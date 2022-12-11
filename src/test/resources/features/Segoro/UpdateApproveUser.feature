Feature: Update Approve User Feature Test
  @user @approve
  Scenario Outline:: Put update approve user to be owner
    Given Put approve user to be owner with valid <id>
    When Send put approve user to be owner request
    Then Status code should be 200 OK
#    And Put update photo profile user with multipart
    Examples:
      | id |
      | 1  |
      | 2  |