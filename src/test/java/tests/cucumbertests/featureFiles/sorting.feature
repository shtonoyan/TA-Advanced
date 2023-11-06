Feature: Launches page table sorting

  Background: Login to the application
    Given Login to the Report Portal

  Scenario: Sorting table by TOTAL
    Given I navigated to the launches page
    When  I click TOTAL column
    Then The column is sorted ascendingly by TOTAL numbers

  Scenario: Sorting table by PASSED
    Given I navigated to the launches page
    When  I click PASSED column
    Then The column is sorted ascendingly by PASSED numbers

  Scenario: Sorting table by FAILED
    Given I navigated to the launches page
    When  I click FAILED column
    Then The column is sorted ascendingly by FAILED numbers