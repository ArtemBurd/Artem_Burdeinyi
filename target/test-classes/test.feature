@selenium
Feature: testing
  Scenario Outline: Go to add user page
    Given User on <page1> page
    When User selects Users
    And User clicks <button>
    Then User go to <page2> page
    Examples:
      |page1|page2|button|
      |"home"|"saveUser"|"addBtn"|

  Scenario Outline: Add user
    Given User on <page1> page
    When User inputs <value1> in <field1>
    And User inputs <value2> in <field2>
    And User inputs <value3> in <field3>
    And User inputs <value3> in <field4>
    And User clicks <button>
    Then User go to <page2> page
    Examples:
      |page1|value1|field1|value2|field2|value3|field3|field4|page2|button|
      |"saveUser"|"Admin A"|"nameField"|"Artem_Burd8"|"usernameField"|"sfgt4545"|"passwordField"|"confirmField"|"users"|"saveBtn"|

    Scenario Outline: Search user by Search button
      Given User on <page1> page
      When User inputs <value1> in <field1>
      And User selects <value2> in <field2>
      And User inputs <value3> in <field3>
      And User selects <value4> in <field4>
      And User clicks <button>
      Then User sees created user
      Examples:
      |page1|value1|field1|value2|field2|value3|field3|value4|field4|button|
      |"users"|"Artem_Burd8"|"searchUsername"|"ESS"|"searchRole"|"Admin A"|"searchName"|"Enabled"|"searchStatus"|"searchUserBtn"|

      Scenario Outline: Search user in the grid
        Given User on <page1> page
        When User clicks <button>
        Then Created user is in the grid
        Examples:
        |page1|button|
        |"users"|"resetBtn"|

        Scenario Outline: Delete user
          Given User on <page1> page
          When User selects checkbox
          And User clicks <button>
          And User confirms deletion
          Then Created user is not in the grid
          Examples:
          |page1|button|
          |"users"|"deleteBtn"|