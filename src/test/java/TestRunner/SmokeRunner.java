package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features",

        glue = "StepDefinitions",
        // we always mention the Directory name inside glue, not class name

        dryRun = false,// dryRun help you to run only code which is undefined or added after
// whenever you added a new feature, you will need dryRun not to execute all project to generate you a new code for the new feature,it will ignore all project and generate you the code for new feature on console
// after you are done with that code,you gotta change it true to false, otherwise it won't run your project

        tags = "@smoke2", // if you want to run only 1 of your test case just put that case name inside tags and run it
        // if you want to run more than 1 case at same time just mention it also inside tags as example shows
// lets assume you have 100 testcases in Features directory and wanna run them all at same time, just remove tags inside the CucumberOptions and run your Runner class
        plugin = {"pretty"} // help ypu to get more info on your console
)
public class SmokeRunner {

}
