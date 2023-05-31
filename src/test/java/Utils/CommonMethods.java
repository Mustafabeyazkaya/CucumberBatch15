package Utils;

import StepDefinitions.PageInitializer;
import io.cucumber.java.eo.Se;
import io.netty.channel.EventLoopException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer { // we always need to extend PageInitializer to CommonMethods to access it from anywhere
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties();// we need to add this in this CommonMethods class to be accessed in anywhere
        // comes from ConfigReader class
        String browserType= ConfigReader.getPropertyValue("browserType");//reading data from the getPropertyValue Method
        switch (browserType){
            case "Chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--no-sandbox");
                ops.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")){
                    ops.addArguments("--headless=new");
                }
                driver=new ChromeDriver(ops);
                break;
            case "Firefox":
                driver=new FirefoxDriver();
                break;
            case "IE":
                driver=new InternetExplorerDriver();
                break;
            default:
                driver=new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));//reading data from the getPropertyValue Method
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.Wait_Time));// we called the final variable from Constants class without extending that class
        initializePageObjects(); // comes from PageInitializer class
        // This will initialize all the pages we have in our PageInitializer class along with the launching of application


        // to configure the File and pattern it has
        DOMConfigurator.configure("log4j.xml");  // when you select DOMConfigurator method it has to be "org.apache.log4j.xml.DOMConfigurator"
        Log.startTestCase("This is the beginning of my Test case");
        Log.info("My test case is executing right now");
        Log.warning("My test case might have some trivial issues");
    }



    public static void closeBrowser(){
        Log.info("This test case is about to get completed");
        Log.endTestCase("This test case is finished");
        driver.close();
    }



    public static void doClick(WebElement element) {
        element.click();
    }




    public static void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }




    public static Select clickOnDropdown(WebElement element){
        Select select=new Select(element);
        return select;
    }



    public static void selectByValue(WebElement element,String value){
        clickOnDropdown(element).selectByValue(value);
    }
    public static void selectByVisibleText(WebElement element,String value){
        clickOnDropdown(element).selectByVisibleText(value);
    }



    public static void selectByIndex(WebElement element,int index){
        clickOnDropdown(element).selectByIndex(index);
    }
    public static void selectByOptions(WebElement element,String text){
        List<WebElement>options=clickOnDropdown(element).getOptions();
        for (WebElement option:options) {
            String ddOptointext=option.getText();
            if (ddOptointext.equals(text)){
                option.click();
            }
        }
    }





    // =======================SCREENSHOT==============================
    public static byte[] takeScreenshot(String imageName) {// return type should be byte array
        // this casts the webDriver instance 'driver' to take screenshot interface
        TakesScreenshot ts = (TakesScreenshot) driver;// go back and study for interfaces

        // this captures the screenshot and store it as byte array
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES); // screenshot are very small size that's why we choose OutputType.BYTES
        // we need array because we will have multiple screenshot

        // this captures the screenshot and stores it as a file in the sourcePath variable
        File sourcePath = ts.getScreenshotAs(OutputType.FILE);

        // this helps you to copy your screenshot that you are taken and having in sourcePath to the FILE that you want to store ss in
        try {                                         // comes from Constant class     // from the variable in method
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("yyyy-MM-dd-HH-mm-ss") +".png"));
        } catch (IOException e) {                                                                     //comes from getTimeStamp the method in CommonMethods
            throw new RuntimeException(e);
        }
        return picBytes;
    }
    // this capture date and time in our system
    public static String getTimeStamp(String pattern){ //pattern=type of your date , for example  yyyy(year)-MM(month)-dd(day)-HH(hour)-mm(minutes)-ss(second)
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }




}
