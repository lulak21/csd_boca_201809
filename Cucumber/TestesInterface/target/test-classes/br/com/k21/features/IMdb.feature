Feature: Movies Simulation

  Scenario: Simple simulation
    Given I am on the movie page
    When I enter "Crazy Rich Asians" movie name
    And click on the movie search button
    Then the page should show me the movie results
    
