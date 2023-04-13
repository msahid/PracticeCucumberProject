Feature: TechFios Login functionality validation

Scenario: User should be able to login with correct credential
    Given User is on the TechFios login page
    When User enters username as "demo@techfios.com"
    When User enters password as "abc123"
    When User clicks on submit button
    Then User should land on dashboard page