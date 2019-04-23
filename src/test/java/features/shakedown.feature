@ShakeDown
Feature: Shakedown

  Scenario Outline: Shakedown for all clubs
    Given I navigate to the landing page for "<club>"
    When I click on the search button
    Then The search results should be displayed on a new page
    
      Examples: 
      | club        |
      | california  |
      | new mexico  |
      | pennsylvania|
      | texas       |