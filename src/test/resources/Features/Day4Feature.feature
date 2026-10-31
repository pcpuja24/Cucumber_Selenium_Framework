Feature: Dashboard Element visibility test


  Background:
    Given user navigated to login page of orange portal
    When user enters valid username "Admin" and password "admin123"
    Then user should be redirected to dashboard page

  Scenario: Dashboard icons post login are appearing or not
    And User should see following dashboard menu items
      | Admin |
      | PIM   |
      | Leave |
      | Time  |

