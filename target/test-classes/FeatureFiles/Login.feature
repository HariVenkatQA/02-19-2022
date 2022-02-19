Feature: To validate the login functionality of facebook

  Background: 
    Given open the browser and hit the url

  Scenario Outline: 
    To validate the login page with various credentials

    When user enter the "<username>"
    Then user enters the "<password>"
    And user clicks the login button
    And User close the browser

    Examples: 
      | username   | password |
      | Hariharan  |    12345 |
      | Manikandan |    56123 |
      | Sara       |      000 |
      | Vicky      |      741 |

  Scenario: 
    When Customer Enters the username
      | manikandan@gmail.com | vicky@gmail.com | paran@yahoo.com |
    Then Customer Enters the password
    And Customer clicks the login button
    And Exits the from the Application
