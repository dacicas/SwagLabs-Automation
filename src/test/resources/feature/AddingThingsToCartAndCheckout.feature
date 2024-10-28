Feature: Shopping Automation
  Scenario: Adding several items to cart
    Given I go to the Website
    When I specify my credentials and click login
    And I add several items to cart
    And I check that those items are added

