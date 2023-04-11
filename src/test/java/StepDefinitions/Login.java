package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class Login extends CommonMethods {// we extended our class to CommonMethods in Utils Package

  /*  @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {           // we don't need to write down because Hooks take care oof pre- and post- conditions for me
      openBrowserAndLaunchApplication();//comes from the Utils package
    }*/
    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
     //driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));//reading data from the getPropertyValue Method
        // instead of this hard coding use the method that i created in commonMethod class
        WebElement usernameTextBox=driver.findElement(By.id("txtUsername"));
        sendText(usernameTextBox,ConfigReader.getPropertyValue("username"));// this sendText method comes from commonMethod class
     //driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));//reading data from the getPropertyValue Method
        // instead of this hard coding use the method that i created in commonMethod class
        WebElement passwordTextBox=driver.findElement(By.id("txtPassword"));
        sendText(passwordTextBox, ConfigReader.getPropertyValue("password"));
    }
    @When("click on login button")
    public void click_on_login_button() {
        WebElement loginBtn=driver.findElement(By.id("btnLogin"));
        doClick(loginBtn);// this method comes from commonMethods class which help us to click on webElement that we provide
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
        WebElement usernameTextBox=driver.findElement(By.id("txtUsername"));
        sendText(usernameTextBox,username);
        WebElement passwordTextBox=driver.findElement(By.id("txtPassword"));
        sendText(passwordTextBox, password);
    }
    }
