package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.PanelUI;

public class EmployeeSearch extends CommonMethods { //we need to extend CommonMethods
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        //WebElement empIdTextBox=driver.findElement(By.id("empsearch_id"));
        sendText(employeeSearchPage.empIdTextBox, ConfigReader.getPropertyValue("empid"));
    }
    @When("click on search button")
    public void click_on_search_button() {
        //WebElement searchBtn=driver.findElement(By.id("searchBtn"));
        doClick(employeeSearchPage.searchBtn);
    }
    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("The employee is displayed");
    }
    @When("users select Job Title")
    public void users_select_job_title() {
        //WebElement jobTitleDroD=driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(employeeSearchPage.jobTitleDroD, ConfigReader.getPropertyValue("jobTitle"));

        //WebElement empStatus=driver.findElement(By.id("empsearch_employee_status"));
        selectByOptions(employeeSearchPage.empStatus,ConfigReader.getPropertyValue("empStatus"));

        //WebElement include=driver.findElement(By.id("empsearch_termination"));
        selectByOptions(employeeSearchPage.include,ConfigReader.getPropertyValue("includeDD"));
    }

}
