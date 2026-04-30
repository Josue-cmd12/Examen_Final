Feature: Product filtering in Shooping Cart application
  As a logged-in user
  I want to filter productos by category
  So I can quickly find items of interest

  Background:
    Given Andrea opens the shopping Cart application
    When she enters her email "user1@test.com" and password "password1"
    And she taps the Login button

    Scenario: Filter products by Electronics category
      When Andrea selects the "Electrónica" category filter
      Then Andrea should see the product "Laptop HP Pavilion"