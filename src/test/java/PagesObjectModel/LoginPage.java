package PagesObjectModel;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods { // it needs to extend CommonMethods class
    /*

    WebElement usernameTextBox=driver.findElement(By.id("txtUsername"));
    WebElement passwordTextBox=driver.findElement(By.id("txtPassword"));
    WebElement loginBtn=driver.findElement(By.id("btnLogin"));
    WebElement welcomeBtn=driver.findElement(By.id("welcome"));
    WebElement logOutBtn=driver.findElement(By.xpath("//a[text()='Logout']"));

    */

    // Page Factory Model (in Selenium)
    // always use this way,
    // Create page factory model by using the above elements
    public LoginPage(){
        PageFactory.initElements(driver,this); // we ALWAYS need to add this on this class
        /*
        PageFactory:  is the name of a class in the Selenium WebDriver library.
.initElements():  is a static method of the PageFactory class that initializes all the elements on a web page that are defined in a particular class.
driver: this is an object of the WebDriver class that is used to control the web browser.
this: This keyword refers to the current instance of the LoginPage class. In this case, we're passing this as a parameter to the initElements method to indicate that we want to initialize the elements on the current page. (edited)
*/
    }
    @FindBy(id="txtUsername")
    public WebElement usernameTextBox; // we need to make it public
    @FindBy(id = "txtPassword")
    public WebElement passwordTextBox;// we need to make it public
    @FindBy(id = "btnLogin")
    public WebElement loginBtn;// we need to make it public
    @FindBy(id = "welcome")
    public WebElement welcomeBtn;// we need to make it public
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOutBtn;// we need to make it public



}
