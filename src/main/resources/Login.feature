Feature: Login Functionality

  Scenario: TC 1 - Error login with invalid credentials
    Given I am on the login page
    When I enter username "incorrectUser" and password "Password123"
    And I click the submit button
    Then I should see an error message "Your username is invalid!"

  Scenario: TC 2 - Successful login
    Given I am on the login page
    When I enter username "student" and password "Password123"
    And I click the submit button
    Then I should be redirected to the "logged-in-successfully" page