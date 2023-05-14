package StepDefinitions;

import PagesObjectModel.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class Login extends CommonMethods {// we extended our class to CommonMethods in Utils Package

  /*  @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {           // we don't need to write down because Hooks take care oof pre- and post- conditions for me
      openBrowserAndLaunchApplication();//comes from the Utils package
    }*/
    //public static  LoginPage login =new LoginPage();// create object of LoginPage class to use the code from inside it
    // we don't need this object if you created PageInitializer class
    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {

     //driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));//reading data from the getPropertyValue Method
        // instead of this hard coding use the method that i created in commonMethod class
        // WebElement usernameTextBox=driver.findElement(By.id("txtUsername")); // you can remove this after declared it in the LoginPage class in Pages Package
        sendText(login.usernameTextBox,ConfigReader.getPropertyValue("username"));// this sendText method comes from commonMethod class
        // login.  comes from LoginPage class
     //driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));//reading data from the getPropertyValue Method
        // instead of this hard coding use the method that i created in commonMethod class
       //WebElement passwordTextBox=driver.findElement(By.id("txtPassword"));// you can remove this after declared it in the LoginPage class in Pages Package
        sendText(login.passwordTextBox, ConfigReader.getPropertyValue("password"));
        // login.  comes from LoginPage class
    }
    @When("click on login button")
    public void click_on_login_button() {
        // WebElement loginBtn=driver.findElement(By.id("btnLogin")); // you can remove this after declared it in the LoginPage class in Pages Package
        doClick(login.loginBtn);// this method comes from commonMethods class which help us to click on webElement that we provide
        // login.  comes from LoginPage class
    }
    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        boolean userloggedIn = driver.findElement(By.xpath("//a[contains(text(), 'Welcome')]")).isDisplayed();
        if (userloggedIn) {
            System.out.println("User is logged in Successfully");
        }
    }
    /*@Then("close the browser")
    public void close_the_browser() {
      closeBrowser();//comes from the Utils package   // we don't need to write down because Hooks take care oof pre- and post- conditions for me
    }*/
    @When("user enters valid username {string} and valid password {string}")
    public void user_enters_valid_username_and_valid_password(String username, String password) { // this is the example which is shown by regular expression(cucumber feature to read data)
        //WebElement usernameTextBox=driver.findElement(By.id("txtUsername")); // you can remove this after declared it in the LoginPage class in Pages Package
        sendText(login.usernameTextBox,username);
        // login.  comes from LoginPage class
        //WebElement passwordTextBox=driver.findElement(By.id("txtPassword")); // you can remove this after declared it in the LoginPage class in Pages Package
        sendText(login.passwordTextBox, password);
        // login.  comes from LoginPage class
    }

    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) { // there was "io.cucumber.datatable.DataTable dataTable" this in the ()
                                                                                                    //just remove "io.cucumber.datatable."
       List<Map<String,String>> userCredentials =dataTable.asMaps(); // asMaps method come after you import DataTable Class into your project
       // in here we are converting our data Table to List of maps
        for (Map <String,String> userCreds:userCredentials) {
            String username=userCreds.get("username");
            String password=userCreds.get("password");

            //WebElement usernameTextBox=driver.findElement(By.id("txtUsername"));// you can remove this after declared it in the LoginPage class in Pages Package
            sendText(login.usernameTextBox,username);
            // login.  comes from LoginPage class

            //WebElement passwordTextBox=driver.findElement(By.id("txtPassword"));// you can remove this after declared it in the LoginPage class in Pages Package
            sendText(login.passwordTextBox,password);
            // login.  comes from LoginPage class

            //WebElement loginBtn=driver.findElement(By.id("btnLogin"));// you can remove this after declared it in the LoginPage class in Pages Package
            doClick(login.loginBtn);
            // login.  comes from LoginPage class

           // WebElement welcomeBtn=driver.findElement(By.id("welcome"));// to keep working, we need to log out of the page that loops enter for first credential
            doClick(login.welcomeBtn);// that's why wee need to click on logout button for each time to be entering for next credentials
            // login.  comes from LoginPage class
            //WebElement logOutBtn=driver.findElement(By.xpath("//a[text()='Logout']"));// you can remove this after declared it in the LoginPage class in Pages Package
            doClick(login.logOutBtn);
            // login.  comes from LoginPage class
        }
    }
}
