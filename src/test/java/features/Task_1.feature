Feature: Presta Shop Portal

  Scenario: Sign in PrestaShop
    Given user is on main page
    When user clicks sign in button
    And fills correct email and password and clicks sign in button
    Then user is logged
    And close the browser

    @loggedUser
    Scenario: Add first address in PrestaShop portal
      Given user is on an account details
      When user clicks Add first address button
      And fills address form and clicks Save button
      Then first address is added
      And close the browser

  @loggedUser
    Scenario Outline: Add new address in PrestaShop portal
      Given user is on an account details page and already has one address added
      When user clicks Address button and Create new Address button
      And fills the form with "<alias>", "<firstName>", "<lastName>", "<address>", "<zipCode>", "<city>", "<phone>" and clicks save button
      Then addresses are added to an account
      And check address with "<alias>", "<firstName>", "<lastName>", "<address>", "<zipCode>", "<city>", "<phone>"
      And delete address
      And close the browser
      Examples:
        | alias     | firstName | lastName | address          | zipCode | city       | phone      |
        | Address 1 | Anna      | Kowalska | New Street 1/34  | 12-344  | Cambridge  | 222333444  |
        | Address 2 | Seba      | Nowak    | Old Street 2/987 | 00-222  | Birmingham | 7778880999 |
        | Address 3 | Zuza      | Combo    | Yellow Street 2  | 33-444  | London     | 227771182  |


