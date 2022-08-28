Feature: Shopping on PrestaShop

  Scenario: Buying sweater on PrestaShop
    Given user is on main page and logged and has one deliver address added
    When user checks price and clicks Hummingbird Printed Sweater
    And chooses size "M" and quantity 5
    And clicks Add to cart button and Proceed to Checkout button
    And confirms address
    And chooses Pick-up in store delivery method
    And chooses Pay by Check method and clicks Order button
    Then user confirmed shopping and made screenshot
    And cclose the browser

  Scenario: Checking order
    Given order was made and user is on an account detail page
    When user clicks Order history and details button
    Then previous order is on the list with correct details
    And cclose the browser


