package RestAPI_AllRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import static org.hamcrest.Matchers.*;

public class TestGetMethod {
	@Test
	void testCase01()
{
	Response response=RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println("Response/Status Code:"+response.getStatusCode());
	System.out.println("Response Body:"+response.getBody().asString());
	System.out.println("Response Time:"+response.getTime());
	System.out.println("Response Header:"+response.getHeader("Content-Type"));
/*validate status code
	//expected status code is 200
	 * */
	int expected_statuscode=200;
	int actual_statuscode=response.getStatusCode();
Assert.assertEquals(expected_statuscode, actual_statuscode);
}
	//BDD Format(given[precondition,when,then])
	@Test
	public void test02()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given()
		.queryParam("page", 2)
		.when().get()
		.then()
		.statusCode(200);
	}
	//pathParameterSample
	@Test
	public void test03()
	{
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.given()
		.pathParam("userid", 2)
		.when().get("/users/{userid}")
		.then()
		.statusCode(200)
		.body("data.id", equalTo(2));	
	}
}

