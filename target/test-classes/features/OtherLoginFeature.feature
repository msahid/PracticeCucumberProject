Feature: TechFios ther Login functionality validation

  Background: 
    Given User is on the TechFios login page

  @OtherScenario1
  Scenario Outline: User should be able to login with correct credential
    When User enters username as "<username>"
    When User enters password as "<password>"
    When User clicks on submit button
    Then User should not land on dashboard page

    Examples: 
      | username           | password |
      | demo2@techfios.com | abc123   |
      | demo@techfios.com  | abc124   |
      | demo2@techfios.com | abc124   |
