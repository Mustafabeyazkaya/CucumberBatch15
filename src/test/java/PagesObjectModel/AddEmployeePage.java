package PagesObjectModel;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods { //we need to extend CommonMethods
    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "menu_pim_viewPimModule" )
    public WebElement pimTab;

    @FindBy ( id = "menu_pim_addEmployee")
    public WebElement AddEmployeeBtn;

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="middleName")
    public WebElement middleName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="btnSave")
    public WebElement saveBtn;

    @FindBy(id="employeeId")
    public WebElement empIDLocator;
 }
