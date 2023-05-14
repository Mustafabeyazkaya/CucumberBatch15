package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods { //we need to extend CommonMethods
    // HOOKS: For defining pre- and post-steps(conditions) in any Cucumber framework
    //      : This is always created inside the StepDefinitions folder
    //      : This class can not be inherited
    //      : Hooks will take care of pre- and post- conditions irrespective
    //      : of what goes in between the test steps
    //      : even your test case failed, the browser will be closed by hooks, if you don't have hooks, your browser won't be closed , when your code failed

    @Before // when you choose Before annotation between all selection select the one which is supported by "io.cucumber.java"
    public void preConditions(){
        openBrowserAndLaunchApplication();
    }
    // Scenario class holds complete information of your tests execution in Cucumber framework
    @After  // when you choose After annotation between all selection select the one which is supported by "io.cucumber.java"
    public void postConditions(Scenario scenario){
        byte [] pic;
        if (scenario.isFailed()){ // if my test case failed
            pic=takeScreenshot("failed/"+scenario.getName()); // create a failed folder which holds screenshot of failed test cases
        }else {
            pic=takeScreenshot("passed/"+scenario.getName());
        }
        // attach the screenshot in my report
        scenario.attach(pic,"image/",scenario.getName());
        closeBrowser();
    }
}
