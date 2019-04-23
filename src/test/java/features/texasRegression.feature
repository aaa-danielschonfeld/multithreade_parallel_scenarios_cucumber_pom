@TexasRegression
Feature: TexasRegression

  Scenario: Regression for Texas
    Given I navigate to the landing page for "texas"
    When I click on the search button
    Then The search results should be displayed on a new page