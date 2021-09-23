Feature: Login for the application

  Scenario: Login with credentials
    Given User is on Home Page
    When The user provide the wrong credentials
    Then The user should see message wrong email pwd