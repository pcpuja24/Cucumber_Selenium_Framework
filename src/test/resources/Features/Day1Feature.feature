Feature: Employee Actions

  Scenario: add Employee in Empty List

    Given An empty employee list
    When An employee is added in list
    Then The employee added to list is visible or not