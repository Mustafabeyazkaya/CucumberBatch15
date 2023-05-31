package Utils;

import org.json.JSONObject;

import javax.swing.plaf.PanelUI;

public class APIPayloadConstants {
    // we will pass the body in multiple formats, for thus we have created this class
    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "    \"emp_firstname\": \"mustafa\",\n" +
                "    \"emp_lastname\": \"beyazkaya\",\n" +
                "    \"emp_middle_name\": \"can\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"1997-09-03\",\n" +
                "    \"emp_status\": \"Confirmed\",\n" +
                "    \"emp_job_title\": \"QA Engineer\"\n" +
                "}";
        return createEmployeePayload;
    }

    // this is the second approach of the creating payload by avoiding extra "//"
    public static String createEmployeePayloadJson(){
        // JSONObject CLASS works as Map does
        JSONObject obj= new JSONObject();
        obj.put("emp_firstname", "mustafa");
        obj.put("emp_lastname", "beyazkaya");
        obj.put("emp_middle_name", "can");
        obj.put("emp_gender","M");
        obj.put("emp_birthday", "1997-09-03");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "QA Engineer");
        return obj.toString();
    }

    //this is the third approach of the creating parametrized overload method
    public static String createEmployeePayloadJsonDynamic(String fName, String lName, String mName, String gender, String bDay, String jobStatus, String jobTitle){
        // JSONObject CLASS works as Map does
        JSONObject obj= new JSONObject();
        obj.put("emp_firstname", fName);
        obj.put("emp_lastname", lName);
        obj.put("emp_middle_name", mName);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday", bDay);
        obj.put("emp_status", jobStatus);
        obj.put("emp_job_title", jobTitle);
        return obj.toString();
    }

    public static String updateEmployeePayloadJson(String empID){
        // JSONObject CLASS works as Map does
        JSONObject obj= new JSONObject();
        obj.put("employee_id",empID); // we sould add this part for updating because after employee is created it has a id number,and if you want to update anything, you need that specific id
        obj.put("emp_firstname", "Leandrass");
        obj.put("emp_lastname", "Stan");
        obj.put("emp_middle_name", "Jay");
        obj.put("emp_gender","M");
        obj.put("emp_birthday", "1970-09-03");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "Junior QA Engineer");
        return obj.toString();
    }
}
