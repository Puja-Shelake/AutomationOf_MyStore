Feature: Cucumber BDD Assignment

Background:
Given  User Launch url




  @RedirectionPage
  Scenario: E-Commerce First Page
  Given User is on home page 
  When User gets redirected URL "http://automationpractice.com/index.php"
  
  @Logo
  Scenario: Logo Visibility
  When After launching Check logo is displayed or not
  And Logo  having width is 350 and height is 99
  
  @ProductCategories
  Scenario: Product categories
  Then After Launching categories of the product count is 3
  When Displayed text the product categoris


@Search
Scenario: Search Product
  When User Enters text “T-shirt”
  Then Search Engine gives suggestion to user with entered text i.e “T-shirt”
  
  
  @twitter
  Scenario: Social Account Name
  When User Click on twitter link its navigated to new window
  And User gets account name is "Selenium Framework"

  
  
  
  #  Given Application URL redirection Redirected to "http://automationpractice.com/index.php"
   # When Application logo visibility
    #And Application logo width is 390 & height is 99
    #And Application product main category list validation
    #Then Application Search functionality
    #Then Application social media handles validation

    