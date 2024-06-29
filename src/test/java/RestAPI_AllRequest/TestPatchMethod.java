package RestAPI_AllRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPatchMethod {
//BDD style
	@Test
	public void test08()
{
	JSONObject jsonData=new JSONObject();
	  jsonData.put("name","Arya");
	RestAssured.baseURI="https://reqres.in/api/users/138";
	RestAssured.given().header("Content-type","application/json")
	.contentType(ContentType.JSON).
	body(jsonData.toJSONString()).
	when().patch().
	then().statusCode(200).log().all();
}
	
	//without BDD style
	@Test
    public void test09() {
        // Create the JSON data
        JSONObject jsonData = new JSONObject();
        jsonData.put("name","Arya");
        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/api";

        // Perform the POST request and get the response
        Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .body(jsonData.toJSONString())
            .patch("/users/138");

        // Validate the response status code
        int statusCode = response.getStatusCode();
        assert statusCode == 200 : "Expected status code 201 but got " + statusCode;

        // Optionally, print the response for verification
        System.out.println("Response Body: " + response.getBody().asString());
    }
}
