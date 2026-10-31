Feature: Login functionality test

  Scenario: valid user login
    Given user navigated to login page of orange portal
    When user enters valid username "Admin" and password "admin123"
    Then user should be redirected to dashboard page

  Scenario Outline: Invalid user login test
    Given user navigated to login page of orange portal
    When user enters username as "<user>" and password as "<pass>"
    Then user verifies error message as "Invalid credentials"
    Examples:
      | user  | pass     |
      | puja  | admin123 |
      | Admin | 12345    |
      | puja  | 12345    |