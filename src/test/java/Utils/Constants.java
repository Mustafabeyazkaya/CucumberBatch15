package Utils;

public class Constants {//this is for UI part
    public static final int Wait_Time=1000;
    public static final String PROPERTY_FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/Config/config.properties"; //put \\ manually before src
    // System.getProperty("user.dir") gives you the path of your code till src package (general)
    public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+ "/screenshot/";
    // we just create a folder between .idea,src and any other folder that we can load our screenshot in
    // And we need to have an object of this in CommonMethods
}
