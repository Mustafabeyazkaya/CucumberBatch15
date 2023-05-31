package APIStepDefinitions;

import Utils.APIConstants;
import Utils.APIPayloadConstants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*; // we always change equalTo to * to be use the import for evey hamcrest matchers

public class APIWorkFlowSteps {
    public static RequestSpecification request;
    Response response;
    public static String employee_id;
    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .header(APIConstants.HEADER_KEY_AUTHORIZATION,
                        GenerateTokenSteps.token)
                .body(APIPayloadConstants.createEmployeePayload());
    }
    // ----------------------------------------------------------
    // another request making with json payload
    @Given("a request is prepared to create an employee using json payload")
    public void a_request_is_prepared_to_create_an_employee_using_json_payload() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .header(APIConstants.HEADER_KEY_AUTHORIZATION,
                        GenerateTokenSteps.token)
                .body(APIPayloadConstants.createEmployeePayloadJson());
    }
    // ----------------------------------------------------------
    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
       response= request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer statusCode) {
        // argument/value is coming from feature file
        response.prettyPrint();
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the employee contains key {string} and value {string}")
    public void the_employee_contains_key_and_value(String key, String value) {// don't change the order of parameters, they are inserted in order at feature file
     // Best Approach For Api Code (hamcrest matcher)
        response.then().assertThat().body(key,equalTo(value));

        // second way to verify which is usually used for selenium or cucumber
     // String actualValue= response.jsonPath().getString(key);
       // Assert.assertEquals(actualValue,value);

    }
    @Then("te employee id {string} is stored as a global variable to be used for other class")
    public void te_employee_id_is_stored_as_a_global_variable_to_be_used_for_other_class(String empId) {
        // in this method we are capturing the empId from database by dynamic way
       employee_id =response.jsonPath().getString(empId);
        System.out.println(employee_id);
    }

    // ----------------------------------------------------------------------
    // after this part is belonged to DATA TABLE
    @Given("a request is prepared to get the created employee")
    public void a_request_is_prepared_to_get_the_created_employee() {
           request = given().header(APIConstants.HEADER_KEY_AUTHORIZATION,GenerateTokenSteps.token).
               queryParam("employee_id",employee_id); // this employee_ id came from the instance variable
    }
    @When("a GET call is made to get the employee")
    public void a_get_call_is_made_to_get_the_employee() {
      response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }
    @Then("the status code for this employee is {int}")
    public void the_status_code_for_this_employee_is(Integer statusCode) {
       response.then().assertThat().statusCode(statusCode);
    }
    @Then("the employee data we get having id {string} must match with globally stored employeeId")
    public void the_employee_data_we_get_having_id_must_match_with_globally_stored_employee_id(String keyOftheValue) {
        // it will store the id coming from get call which will be compared to global employee id
       String actualId=response.jsonPath().getString(keyOftheValue);
        //assertion we will add
        Assert.assertEquals(employee_id, actualId);
    }
    @Then("the retrieved data at {string} object matches with the data of created employee")
    public void the_retrieved_data_at_object_matches_with_the_data_of_created_employee(String empObject, DataTable dataTable) {
        List<Map<String,String>> expectedData = dataTable.asMaps(); // dataTable.asMaps(String.class,String.class); // this is your choose to put String.class, it is not must

        Map<String,String> actualData = response.body().jsonPath().get(empObject);

        for (Map<String,String> expected:expectedData) {
            Set<String> keysOfExpectedData =expected.keySet(); // it will store all the expected data keys
            // another enhanced for loop to get values and keys
            for (String key:keysOfExpectedData) {
                String expectedValue = expected.get(key); // to get value from expectedData Maps
                String actualValue = actualData.get(key); // to get value from actualData Maps
                // this is hamcrest
                //response.then().assertThat().body(expectedValue,equalTo(actualValue));
                Assert.assertEquals(expectedValue,actualValue);
            }
        }
    }

    @Given("a request is prepared to create an employee with dynamic data {string}, {string},{string},{string},{string},{string},{string}")
    public void a_request_is_prepared_to_create_an_employee_with_dynamic_data(String fName, String lName, String mName, String gender, String bDay, String jobStatus, String jobTitle) {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .header(APIConstants.HEADER_KEY_AUTHORIZATION,
                        GenerateTokenSteps.token)
                .body(APIPayloadConstants.
                        createEmployeePayloadJsonDynamic(fName,lName,mName,gender,bDay,jobStatus,jobTitle)); // pay attention, the method is Json type
    }

    @Given("a request is prepared to update an employee")
    public void a_request_is_prepared_to_update_an_employee() {
        request=given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_KEY_AUTHORIZATION,GenerateTokenSteps.token).
                body(APIPayloadConstants.updateEmployeePayloadJson(employee_id));
    }
    @When("a PUT call is made to update an employee")
    public void a_put_call_is_made_to_update_an_employee() {
       response=request.when().put(APIConstants.UPDATE_EMPLOYEE_URI);
    }
    @Then("the status code of updated employee is {int}")
    public void the_status_code_of_updated_employee_is(Integer statusCodeOfUpdating) {
       response.then().assertThat().statusCode(statusCodeOfUpdating);
    }


}
