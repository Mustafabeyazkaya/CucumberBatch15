package APIStepDefinitions;

import Utils.APIConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {
    // THIS IS HARD CODING
    //String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api"; // shoul be with io.restassured.RestAssured
   String baseURI= APIConstants.BaseURI;
    public static String token ;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification generateTokenRequest=given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body("{\n" +
                "    \"email\": \"mustafabeyazkayaB15@test.com\",\n" +
                "    \"password\": \"test123\"\n" +
                "}");

        // hitting the EndPoint
        Response response=generateTokenRequest.when().post(APIConstants.GENERATE_TOKEN_URI);
        // storing the token in global variable of TOKEN which we created beginning of the class without parameter
        token ="Bearer "+response.jsonPath().getString("token"); // The key which is inside getString method comes always from postman
                                                                      // it gives you the value of the key that you passed into getString method
        // never forget the 1 space after Bearer, check out above code
        System.out.println(token);
        response.then().assertThat().statusCode(200);
    }


}
