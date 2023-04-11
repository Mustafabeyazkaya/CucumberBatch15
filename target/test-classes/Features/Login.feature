Feature: Login Functionalities
  @smoke
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

    #HOOKS: For defining pre and post steps(conditions) in any Cucumber framework
    #     : This is always created inside the StepDefinitions folder
    #     : This class con not be inherited
    #     : Hooks will take care of pre- and post- conditions irrespective
    #      : of what goes in between the test steps