Feature: Send Form

  @SendForm @HappyPath
  Scenario: Fill in all form fields properly and send the form
    Given the user acess Vehicle Insurance Page
    And fills in all "Enter Vehicle Data" data
    And fills in all "Enter Insurant Data" data
    And fills in all "Enter Product Data" data
    And fills in all "Select Price Option" data
    And fills in all "Send Quote" data
    When the user sends the form
    Then the user should see a confirmation message

  @SendForm @UnhappyPath
  Scenario: Fill in form fields incorrectly and validate submit form error
    Given the user acess Vehicle Insurance Page
    And fills in all "Enter Vehicle Data" data
    And fills in all "Enter Insurant Data" data
    And fills in incorrect "Enter Product Data" data
    When the user switches to "Select Price Option" tab
    Then the user should see a loading image caused by incorrect data
