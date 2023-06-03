package Utils;

import io.restassured.RestAssured;

public class APIConstants {

    // CREATING CONSTANTS FOR ENDPOINTS
    public static final String BaseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api"; // you should always add " http://
    public static final String GENERATE_TOKEN_URI= BaseURI+"/generateToken.php";
    public static final String CREATE_EMPLOYEE_URI= BaseURI+"/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URI=BaseURI+"/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI =BaseURI+"/updateEmployee.php";
    public static final String GET_ALL_EMPLOYEES_URI =BaseURI+"/getAllEmployees.php";
    public static final String PARTIALLY_UPDATE_EMPLOYEE_URI =BaseURI+"/updatePartialEmployee.php";
    public static final String GET_EMPLOYEE_STATUS_URI =BaseURI+"//employeementStatus.php";
    public static final String DELETE_EMPLOYEE_URI =BaseURI+"/deleteEmployee.php";
    public static final String JOB_TITLE_EMPLOYEE_URI =BaseURI+"//jobTitle.php";



    // CREATING CONSTANTS FOR HEADERS
    public static final String HEADER_CONTENT_TYPE_KEY="Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE ="application/json";
    public static final String HEADER_KEY_AUTHORIZATION="Authorization";

}
