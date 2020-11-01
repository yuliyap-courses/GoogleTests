Feature:  Open Google page as Guest and use search field

  Scenario: Open Google page and enter city on search field
    Given I  open Google page
    When I enter "Minsk" on search field
    When  I click to Search button
    Then I can see  result of search

