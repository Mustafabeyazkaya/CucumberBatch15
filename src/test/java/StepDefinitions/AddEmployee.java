package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddEmployee extends CommonMethods { //we need to extend CommonMethods
    //public static AddEmployeePage addEmployeePage=new AddEmployeePage(); // you can delete this after you added this object into PageInitializer class
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        //WebElement pimTab=driver.findElement(By.id("menu_pim_viewPimModule"));// you can remove this after declared it in the AddEmployeePage class in Pages Package
        doClick(addEmployeePage.pimTab);// this method comes from commonMethods class which help us to click on webElement that we provide
        //addEmployeePage comes from AddEmployeePage
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        //WebElement addEmployeeBtn=driver.findElement(By.id("menu_pim_addEmployee"));// you can remove this after declared it in the AddEmployeePage class in Pages Package
        doClick(addEmployeePage.AddEmployeeBtn);// this method comes from commonMethods class which help us to click on webElement that we provide
        //addEmployeePage comes from AddEmployeePage
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        //driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstname"));//reading data from the getPropertyValue Method
        // instead of this hard coding use the method that i created in commonMethod class
        //WebElement firstName=driver.findElement(By.id("firstName"));// you can remove this after declared it in the AddEmployeePage class in Pages Package
        sendText(addEmployeePage.firstName, ConfigReader.getPropertyValue("firstname"));//addEmployeePage comes from AddEmployeePage
        //driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));//reading data from the getPropertyValue Method
        //WebElement middleName=driver.findElement(By.id("middleName"));// you can remove this after declared it in the AddEmployeePage class in Pages Package
        sendText(addEmployeePage.middleName, ConfigReader.getPropertyValue("middlename"));//addEmployeePage comes from AddEmployeePage
        //driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));//reading data from the getPropertyValue Method
        //WebElement lastName=driver.findElement(By.id("lastName"));// you can remove this after declared it in the AddEmployeePage class in Pages Package
        sendText(addEmployeePage.lastName, ConfigReader.getPropertyValue("lastname"));//addEmployeePage comes from AddEmployeePage
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        Assert.assertTrue(addEmployeePage.saveBtn.isDisplayed());
        //WebElement saveBtn=driver.findElement(By.id("btnSave"));// you can remove this after declared it in the AddEmployeePage class in Pages Package
        doClick(addEmployeePage.saveBtn);// this method comes from commonMethods class which help us to click on webElement that we provide
        //addEmployeePage comes from AddEmployeePage
    }



    // this is for BACKEND

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstname, String middlename, String lastname) {
      sendText(addEmployeePage.firstName,firstname);
      sendText(addEmployeePage.middleName,middlename);
      sendText(addEmployeePage.lastName,lastname);

    }
    @When("user captures the employee id")
    public void user_captures_the_employee_id(){ // this code will capture the emp_id from UI part, frontend part
       GlobalVariables.emp_id= addEmployeePage.empIDLocator.getAttribute("value"); // this will go to website and check all the empID
                                                                                  // and will store it in the variable that we created in GlobalVariable class
        System.out.println("The employee id is: "+GlobalVariables.emp_id);
    }
    @When("query the information in backend")
    public void query_the_information_in_backend() {
        String query="select * from hs_hr_employees where employee_id = '"+GlobalVariables.emp_id+ "'";
        // to store the table coming from dataBase we use GlobalVariable here
        // in this variable we got all the keys and values for the employee we searched
        GlobalVariables.tableData=DBUtility.getListOfMapsFromRset(query);
    }
    @Then("verify the results from frontend and backend")
    public void verify_the_results_from_frontend_and_backend() {
        // now, from all this values we need to compare one by one value
        String firstNameFromDB = GlobalVariables.tableData.get(0).get("emp_firstname");
                                // get 0 is coming from header
        System.out.println(firstNameFromDB);

        String lastNameFromDB = GlobalVariables.tableData.get(0).get("emp_lastname");
        System.out.println(lastNameFromDB);

        Assert.assertEquals(firstNameFromDB,"nesha");
        Assert.assertEquals(lastNameFromDB,"standart");
        System.out.println("My assertion has passed my test case");
    }
}
