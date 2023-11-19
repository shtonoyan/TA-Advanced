Feature: Launches page filters presence
  Background: Login to the application
    Given Login to the Report Portal

  Scenario: Verify filters presence on launches page
    Given I navigated to the launches page
    Then Filter is displayed
      | total  |
      | passed |
      | failed |