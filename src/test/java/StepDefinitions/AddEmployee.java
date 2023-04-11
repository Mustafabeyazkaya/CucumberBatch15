package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimTab=driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(pimTab);// this method comes from commonMethods class which help us to click on webElement that we provide
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        WebElement addEmployeeBtn=driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmployeeBtn);// this method comes from commonMethods class which help us to click on webElement that we provide
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        //driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstname"));//reading data from the getPropertyValue Method
        // instead of this hard coding use the method that i created in commonMethod class
        WebElement firstName=driver.findElement(By.id("firstName"));
        sendText(firstName,ConfigReader.getPropertyValue("firstname"));
        //driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));//reading data from the getPropertyValue Method
        WebElement middleName=driver.findElement(By.id("middleName"));
        sendText(middleName,ConfigReader.getPropertyValue("middlename"));
        //driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));//reading data from the getPropertyValue Method
        WebElement lastName=driver.findElement(By.id("lastName"));
        sendText(lastName,ConfigReader.getPropertyValue("lastname"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveBtn=driver.findElement(By.id("btnSave"));
        doClick(saveBtn);// this method comes from commonMethods class which help us to click on webElement that we provide
    }
}
