Feature: Login Functionalities
  @smoke3
  Scenario: Valid Admin Login
    # Given open the browser and launch HRMS application , after we created Hooks class we don't ned this step
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully
    # And close the browser , after we created Hooks class we don't ned this step

  @smoke2
  Scenario: Valid Admin Login
    # Given open the browser and launch HRMS application , after we created Hooks class we don't ned this step
    When user enters valid username "admin" and valid password "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    # And close the browser , after we created Hooks class we don't ned this step

    @scenarioOutline
   #Parameterization / Data driven
    Scenario Outline: Login with multiple credentials using Scenario OutLine
      # Given open the browser and launch HRMS application , after we created Hooks class we don't ned this step
      When user enters valid username "<username>" and valid password "<password>"
      And click on login button
      Then user is logged in successfully
      # And close the browser , after we created Hooks class we don't ned this step
     Examples:
      | username | password |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |

      @dataTable
      #Data Table (Launch browser only 1 time)
    Scenario: Login with multiple credentials using Data Table
      When user enters username and password and verifies login
        | username | password |
        | admin    | Hum@nhrm123 |
        | ADMIN    | Hum@nhrm123 |
        | Jason    | Hum@nhrm123 |
