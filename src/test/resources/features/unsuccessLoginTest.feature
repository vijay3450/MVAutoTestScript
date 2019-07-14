Feature: Facebook Login

  Scenario Outline: Validate Unsuccessful login of facebook                             
    Given open the browser and launch the "https://www.facebook.com/"
    Then verify home page title "Facebook – log in or sign up"
    When Page loaded successfully enter a valid "<username>" and a invalid password "<password>"
    And click on the login button
    Then verify the unsuccessful login page title "Log in to Facebook | Facebook" and password error message "<pass_err_msg>" 
    And close the browser
    
    Examples:
    | username | password | title1 |pass_err_msg |
    | pvijaybtech@gmail.com | xyz1 | Facebook – log in or sign up |The password that you've entered is incorrect. Forgotten password? |

