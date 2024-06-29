package RestAPI_AllRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPutMethod {
//BDD style
	@Test
	public void test06()
{
	JSONObject jsonData=new JSONObject();
	jsonData.put("name","Suman");
	jsonData.put("job","SDET02");
	RestAssured.baseURI="https://reqres.in/api/users/138";
	RestAssured.given().header("Content-type","application/json")
	.contentType(ContentType.JSON).
	body(jsonData.toJSONString()).
	when().put().
	then().statusCode(200).log().all();
}
	
	//without BDD style
	@Test
    public void test07() {
        // Create the JSON data
        JSONObject jsonData = new JSONObject();
    	jsonData.put("name","Suman");
    	jsonData.put("job","SDET02");

        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/api";

        // Perform the POST request and get the response
        Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .body(jsonData.toJSONString())
            .put("/users/138");

        // Validate the response status code
        int statusCode = response.getStatusCode();
        assert statusCode == 200 : "Expected status code 201 but got " + statusCode;

        // Optionally, print the response for verification
        System.out.println("Response Body: " + response.getBody().asString());
    }
}
