Feature: Browsing around

  Background: 
    Given I have opened the browser
    And I am on the home page

  Scenario: Login and Vets
    When I open veterinarians page
    Then I search for text "Veterinarians"

  Scenario: Login and check owner based on last name
    When I search owner "Estaban"
    Then I get owner "Estaban" Informations
