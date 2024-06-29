package RestAPI_AllRequest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestDeleteMethod {
//BDD style
	@Test
	public void test10()
{
	RestAssured.baseURI="https://reqres.in/api/users/424";
	RestAssured.given().
	when().delete().then().log().all()
	.statusCode(204);
}
	/*
	@Test
    public void test11() {
        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/api";

        // Perform the DELETE request and get the response
        Response response = RestAssured.given()
            .delete("/users/138");

        // Validate the response status code
        int statusCode = response.getStatusCode();
        assert statusCode == 204 : "Expected status code 204 but got " + statusCode;

        // Optionally, log the response for verification
        System.out.println("Response Body: " + response.getBody().asString());
    }
    */
}
