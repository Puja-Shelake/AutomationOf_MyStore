@All
Feature: Cucumber BDD Assignment

  Background: 
    Given User Launch url

  @RedirectionPage
  Scenario: E-Commerce First Page
    When User is on home page
    Then User gets redirected URL "http://automationpractice.com/index.php"

  @Logo
  Scenario: Logo Visibility
    When After launching Check logo is displayed or not
    Then Logo  having width is 350 and height is 99

  @ProductCategories
  Scenario: Product categories
    Then After Launching categories of the product count is 3
    And Displayed text the product categoris

  @Search
  Scenario: Search Product
    When User Enters text “T-shirt”
    Then Search Engine gives suggestion to user with entered text i.e “T-shirt”

  @twitter
  Scenario: Social Account Name
    When User Click on twitter link its navigated to new window
    Then User gets account name is "Selenium Framework"
