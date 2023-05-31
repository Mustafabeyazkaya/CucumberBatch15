package Utils;

import io.opentelemetry.api.internal.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {//this is for UI part
    static Properties prop;
   public static Properties readProperties(){
       try {
           FileInputStream fileInputStream=new FileInputStream(Constants.PROPERTY_FILE_PATH);// it comes from PROPERTY_FILE_PATH method in Constants class in Utils package
           prop =new Properties();
           prop.load(fileInputStream);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       return prop;
   }
   public static String getPropertyValue(String propertyKey){
      return prop.getProperty(propertyKey);// it will give you the value of the variable that you passed as propertyKey from Properties method which is loaded By config.properties file at Config folder in resources package
   }
}
