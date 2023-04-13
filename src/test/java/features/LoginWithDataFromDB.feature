@DbFeature @Regression
Feature: TechFios Login functionality validation

  @DbScenario1 @Smoke
  Scenario: User should be able to login with correct credential
    Given User is on the TechFios login page
    When User enters "username" from database
    When User enters "password" from database
    When User clicks on submit button
    Then User should land on dashboard page