Feature: Get User by ID

  @user @getUser
    Scenario Outline: Get single user with valid user <id>
      Given Get single user with parameter user <id>
      When Send get single user request
      Then Status code should be 200 OK
      And Response body page user user be <id>
      And Validate user by id with json schema
    Examples:
      | id |
      | 35 |
