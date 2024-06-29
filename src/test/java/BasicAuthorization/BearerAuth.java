package BasicAuthorization;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class BearerAuth {
	//Bearer Token required for post request
	@Test
	public void BearerToken()
	{
		//https://gorest.co.in/public/v2/users
		//create request specification
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");	

		JSONObject payload = new JSONObject();
		payload.put("name", "anuradha");
		payload.put("gender", "Female");
		payload.put("email", "anuradhas123@gmail.com");
		payload.put("status", "Active");
		
		String AuthToken = "Bearer 074b936f0ca3a33175e6715789319b0fbc1d74ffc524017d21e499c787ed1591";
	
		requestSpec.headers("Authorization", AuthToken).
		contentType(ContentType.JSON).
		body(payload.toJSONString());
		
		//perform post request
		Response response = requestSpec.post();
		

		//validate status code 
		Assert.assertEquals(response.statusCode()/*actual*/, 201/*expected*/,"check for status code");
	
		//print status line & response boy
		System.out.println("Responsne status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());
		
		
	}
}
