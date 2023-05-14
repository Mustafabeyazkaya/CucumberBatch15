Feature: Searching the employee
   # Background is used to have commons steps for all the test cases
   # Background This is used to define all the common steps that multiple
   # scenarios have in the same feature file, till the time flow is not broken
  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke1
  Scenario: Search employee by id
    # Given open the browser and launch HRMS application     , after we created Hooks class we don't ned this step           , this is in hooks class
    # When user enters valid email and valid password                                                                        , this is in Background
    # And click on login button                                                                                              , this is in Background
    # When user clicks on PIM option                                                                                         , this is in Background
    When user enters valid employee id
    And click on search button
    And user see employee information is displayed
    # And close the browser                                   , after we created Hooks class we don't ned this step           , this is in hooks class

  @smoke4
    Scenario: Search Employee By Job Title
      # Given open the browser and launch HRMS application    , this is in hooks class
      # When user enters valid email and valid password       , this is in Background
      # And click on login button                             , this is in Background
      # When user clicks on PIM option                        , this is in Background
      When users select Job Title
      And click on search button
      And user see employee information is displayed
      # And close the browser                                  , this is in hooks class