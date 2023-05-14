package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed.txt",// to execute only our failed cases we need to change this path, and we always need to add @ begging of the path
        glue = "StepDefinitions",
        dryRun  = false,
        //tags = "@testcase2", // and we don't need this
        plugin = {"pretty"/*,"html:target/Cucumber.html","json:target/Cucumber.json","rerun:target/failed.txt"*/} ) // and we don't need these

public class FailedRunner {
}
