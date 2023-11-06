Feature: Login to the application

  Scenario: Positive scenario
    When  I complete the username field with "stonoyan"
    And I complete the password field with "P@ssw0rd123?!?!"
    And I click the login button
    Then I am successfully logged in to the application

  Scenario Outline: Negative scenario
    When  I complete the username field with <Username>
    And I complete the password field with <Password>
    And I click the login button
    Then An error message is being shown
    Examples:
      | Username   | Password          |
      | "stonoyan" | "invalid"         |
      | "invalid"  | "P@ssw0rd123?!?!" |
      | "invalid"  | "invalid"         |