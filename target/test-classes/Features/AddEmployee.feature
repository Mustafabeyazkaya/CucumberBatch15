Feature: Employee
  @testcase2 @smoke #to add @testcase help you to put your cases in order and help you to run them single if you want
  Scenario: Adding a new Employee
    # Given open the browser and launch HRMS application , after we created Hooks class we don't ned this step
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee button
    And user enters firstname and middlename and lastname
    And user clicks on save button
    # And close the browser , after we created Hooks class we don't ned this step
