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

//tags option will execute the tagged testcase as mentioned in your runner class
        tags = "@smoke3",// if you want to run only 1 of your test case just put that case name inside tags and run it
        // if you want to run more than 1 case at same time just mention it also inside tags as example shows
// lets assume you have 100 testcases in Features directory and want to run them all at same time, just remove tags inside the CucumberOptions and run your Runner class
        plugin = {"pretty","html:target/Cucumber.html","json:target/Cucumber.json","rerun:target/failed.txt"} // help you to get more info on your console
        // "html:" is type of your report, "target" is the folder that you want to store in , "/Cucumber.html" is name of file that you want to create
        // "json:" is type of your report, "target" is the folder that you want to store in , "/Cucumber.json" is name of file that you want to create
        // "rerun:target/failed.txt" is for the failed executions if you have
        // anytime that you run after created a report file, just go to project name right click and click on the Reload From Disk
        // then find the File that you create and right click, then click on Open In, then click on Browser, then click on any type of browser that you want to open with
)
public class SmokeRunner {
}
// target folder is mostly used for storing the test case execution reports generated using Cucumber
