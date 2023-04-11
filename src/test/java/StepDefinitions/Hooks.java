package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {
    // HOOKS: For defining pre- and post-steps(conditions) in any Cucumber framework
    //      : This is always created inside the StepDefinitions folder
    //      : This class con not be inherited
    //      : Hooks will take care of pre- and post- conditions irrespective
    //      : of what goes in between the test steps

    @Before // when you choose Before annotation between all selection select the one which is supported by "io.cucumber.java"
    public void preConditions(){
        openBrowserAndLaunchApplication();
    }
    @After  // when you choose After annotation between all selection select the one which is supported by "io.cucumber.java"
    public void postConditions(){
        closeBrowser();
    }
}
