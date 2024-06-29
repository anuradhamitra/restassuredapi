package RestAPI_AllRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPostMethod {
//BDD style
	@Test
	public void test04()
{
	JSONObject jsonData=new JSONObject();
	jsonData.put("name","AnuradhaMitra");
	jsonData.put("job","SDET");
	RestAssured.baseURI="https://reqres.in/api/users";
	RestAssured.given().header("Content-type","application/json")
	.contentType(ContentType.JSON).
	body(jsonData.toJSONString()).
	when().post().
	then().statusCode(201).log().all();
}
	
	//without BDD style
	@Test
    public void test05() {
        // Create the JSON data
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "AnuradhaMitra");
        jsonData.put("job", "SDET");

        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/api";

        // Perform the POST request and get the response
        Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .body(jsonData.toJSONString())
            .post("/users");

        // Validate the response status code
        int statusCode = response.getStatusCode();
        assert statusCode == 201 : "Expected status code 201 but got " + statusCode;

        // Optionally, print the response for verification
        System.out.println("Response Body: " + response.getBody().asString());
    }
}
