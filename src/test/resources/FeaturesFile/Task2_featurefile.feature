Feature: Searching a name in orange hrm portal

  Background:
    Given Opening the login portal


  Scenario: Sign in with valid credentials to orange hrm
    When I enter my valid username Admin and password
    And I click on Sign In button
    Then I should be successfully logged in

  Scenario:Sign in with invalid credentials to orange hrm
    When I enter my valid username john_doe and password Secret123
    And I click on Sign In button
    Then I should get error message as Invalid credentials

  Scenario: Searching for the records in admin page
    When I enter my valid username Admin and password
    And I click on Sign In button
    And navigating to admin page
    When entering the username Amit.karanja123  for searching in admin page
    And clicking on the search button
    Then verfying the Screenshot

  Scenario: Sign out of the orange HRM application
    When I enter my valid username Admin and password
    And I click on Sign In button
    And Clicking on the profile icon
    And logging out of orange hrm
    Then verifying we are in login page