package PagesObjectModel;

import StepDefinitions.EmployeeSearch;
import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeSearchPage extends CommonMethods { //we need to extend CommonMethods
    public EmployeeSearchPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy( id = "empsearch_id")
    public WebElement  empIdTextBox;
    @FindBy( id = "searchBtn")
    public WebElement searchBtn ;
    @FindBy( id = "empsearch_job_title")
    public WebElement  jobTitleDroD;
    @FindBy( id = "empsearch_employee_status")
    public WebElement  empStatus;
    @FindBy( id = "empsearch_termination")
    public WebElement  include;

}
