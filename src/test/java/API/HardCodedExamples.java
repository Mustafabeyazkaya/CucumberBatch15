package API;

import Utils.APIConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //  we need to add this to run our method in order (this is a temporary solution)
public class HardCodedExamples {
    // base URI is automatically involved in each method, you don't need to implement in the each method
    // check the first method which is createEmployee, in that we did not mention base URI in there but when you run that method it works
    String baseURI = APIConstants.BaseURI; // shoul be with io.restassured.RestAssured
    // this is coming from APIConstant class
    // http:// is must
    // hrm.syntaxtechs.net/syntaxapi/api     is  the base URL

    String token = "Bearer " +
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUyMDIyMjMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTI0NTQyMywidXNlcklkIjoiNTI1OCJ9.X3-lNfoFQp710kGjO-EFvFLr1ABF5Ht1wexPtq2Tpw8";
    // this is the token that you need to renew it each time.
    // in postman app, you can find it in GLOBALS as JWT
    static String employeeID;

    @Test  // should be org.junit.Test
    // after added this annotation, a green arrow will pop up at the side and you can just run your annotation from there
    public void acreateEmployee() { // i added "a" beginning of the method name to put methods in order
        // prepare the request ( to prepare the request, REST assured API has a class of RequestSpecification to use )
        RequestSpecification prepareRequest = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .header(APIConstants.HEADER_KEY_AUTHORIZATION, token)// this is coming from APIConstant class
                .body("{\n" +
                        "    \"emp_firstname\": \"mustafa\",\n" +
                        "    \"emp_lastname\": \"beyazkaya\",\n" +
                        "    \"emp_middle_name\": \"can\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1997-09-03\",\n" +
                        "    \"emp_status\": \"Confirmed\",\n" +
                        "    \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");// should be io.restassured.specification.RequestSpecification
        // given() is a method that we need to write manually and import it
        // header() is a method that we need to use for adding our informations in HEADER section in postman (Content-Type and application/json
        // body() is a method that we need to use for adding our informations in BODY in postman
        //-------------------------------------------------
        // hitting the EndPoint/send the request
        Response response = prepareRequest.when().post(APIConstants.CREATE_EMPLOYEE_URI); // should be io.restassured.response.Response
        // this is coming from APIConstant class
        // when() means you are gonna send a request
        // post() means is a request type for creating POST for creating in postman
        // post() is a method that we need to use for adding our endpoint in it
        //-------------------------------------------------
        response.prettyPrint();
        // it will print the output in the console
        //************** in API we don't use sout, we use prettyPrint() method******

        // verifying the assertions/get response
        response.then().assertThat().statusCode(201);// we always make sure the API status code
        // then() means you are going to verify the information
        // assertThat() method help us to assert our data
        // statusCode() is a method that we want to assert which data is

        // we are capturing employee id from the response
        employeeID = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employeeID);

        // verifying the firstname in the response body in postman
        response.then().assertThat().body("Employee.emp_firstname", equalTo("mustafa"));
        // Employee.emp_firstname    comes from postman which is the located in BODY section in RESPONSE
        // equalTo() is a method which we need to import by manually
        response.then().assertThat().body("Employee.emp_lastname", equalTo("beyazkaya"));
        // Employee.emp_lastname    comes from postman which is the located in BODY section in RESPONSE
        // equalTo() is a method which we need to import by manually
        response.then().assertThat().header("Content-Type", "application/json");
        System.out.println("My test case is passed");
    }

    @Test
    public void bgetOneEmployee() { // i added "b" beginning of the method name to put methods in order
        RequestSpecification prepareRequest = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION, token).queryParam("employee_id", employeeID);// this is coming from APIConstant class

        // hitting the EndPoint
        Response response = prepareRequest.when().get(APIConstants.GET_ONE_EMPLOYEE_URI); // it should be get, because we are retrieving data
        // this is coming from APIConstant class
        response.prettyPrint();
        //verify the response
        response.then().assertThat().statusCode(200);// we always make sure the API status code
        String temporaryEmpId=response.jsonPath().getString("employee.employee_id");

        // we have 2 employee id, one is global and second is local
        Assert.assertEquals(employeeID,temporaryEmpId); // to compare actual employeeId with temporaryEmployeeId
        // to make sure we are working on the same employee
    }
    // in homework, create a method to get all employee status and job titles
    @Test
    public void cupdateEmployee(){ // i added "c" beginning of the method name to put methods in order
        RequestSpecification prepareRequest = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE).
                // this is coming from APIConstant class
               header(APIConstants.HEADER_KEY_AUTHORIZATION, token).body("{\n" +
                        "    \"employee_id\": \""+employeeID+"\",\n" +
                        "    \"emp_firstname\": \"mustafa\",\n" +
                        "    \"emp_lastname\": \"beyazkaya\",\n" +
                        "    \"emp_middle_name\": \"can\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1998-09-03\",\n" +
                        "    \"emp_status\": \"Hired\",\n" +
                        "    \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");
        // hitting the EndPoint
        Response response=prepareRequest.when().put(APIConstants.UPDATE_EMPLOYEE_URI); // it should be Put, because we are updating data
        // this is coming from APIConstant class
        response.prettyPrint();
        response.then().assertThat().statusCode(200); // we always make sure the API status code

        // for verification
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));// equalTo() is a method which we need to import by manually
        // if you want to check anything on response section in postman, use .body() method here and add that thing inside
    }
    @Test
    public void dgetUpdatedEmployee(){
        // this is coming from APIConstant class
        RequestSpecification prepareRequest = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION,token).queryParam("employee_id",employeeID);
// this is coming from APIConstant class
        Response response= prepareRequest.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);// this is coming from APIConstant class
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
         // if you want to verify the body of the response.
        // you can do that using hamcrest matchers

    }
}
