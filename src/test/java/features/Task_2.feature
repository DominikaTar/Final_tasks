Feature: Shopping on PrestaShop

  Scenario: Buying sweater on PrestaShop
    Given user is on main page and logged and has one deliver address added
    When user clicks Hummingbird Printed Sweater
    And chooses size M and quantity 5
    And clicks Add to cart button and Proceed to Checkout button
    And confirms address
    And chooses Pick-up in store delivery method
    And chooses Pay by Check method and clicks Order button
    Then user confirmed shopping and made screenshot
    And cclose the browser


