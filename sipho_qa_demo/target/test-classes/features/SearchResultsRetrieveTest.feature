@tag
Feature: Report on the top 3 finishers of the 2023 Las Vegas Grand Prix
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Positive Test of getting the top 3 finishers of the 2023 Las Vegas Grand Prix
    Given User is in the BBC Sport feeds page 
    When User navigates to the formular one race results
    	And User selects year 2023 in the formular one results datepicker
    And User cliks in the Las Vegas Grand Prix
    Then The top 3 winers of the Las Vegas Grand Prix race is displayed

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
