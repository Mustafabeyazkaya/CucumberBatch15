package StepDefinitions;

import PagesObjectModel.AddEmployeePage;
import PagesObjectModel.EmployeeSearchPage;
import PagesObjectModel.LoginPage;

public class PageInitializer {
    // This class will manage the object creation of different page Object in our Framework.
    //Instead of calling the page objects again and again, this class will take good care of that step
    //which every class that you created , should be created object in here

    public static LoginPage login;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;
    public static void initializePageObjects(){
        login =new LoginPage();
        addEmployeePage=new AddEmployeePage();
        employeeSearchPage=new EmployeeSearchPage();
    }
}
