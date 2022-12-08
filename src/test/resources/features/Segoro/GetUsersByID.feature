Feature: Get User by ID

  @user @getUser
    Scenario Outline: Get single user with valid user <id>
      Given Get single user with parameter user <id>
      When Send get single user request
      Then Status code should be 200 OK
      And Response body page user be <id>
      And Validate login with json schema
    Examples:
      | id |
      | 1  |
      | 2  |
