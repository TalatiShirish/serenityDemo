Feature: Admin Login feature


  Scenario: Admin Login
    Given Launch application
    When User type : "demo" at "User Name Textbox" on page "Login"
    And User type : "demo" at "Password Textbox" on page "Login"
    And User click on button "Login Button" on page "Login"
#    Then Validate "Dashboard" page is displayed
    And Validate text "Dashboard" is displayed in "Dashboard Label" on page "Dashboard"