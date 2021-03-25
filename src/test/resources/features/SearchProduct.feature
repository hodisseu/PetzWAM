Feature: Search a Product
  Scenario: Search a simple product with success
    Given I access Petz's homepage
    When I search "Aquario"
    Then I see a list of product "Aquario"
    And I click at product "Aquário Boyu Curvo 100 187 Litros Preto Champagne"
    Then Show the title "Aquário Boyu Curvo 100 187 Litros Preto Champagne" and price "R$ 3.199,99"
