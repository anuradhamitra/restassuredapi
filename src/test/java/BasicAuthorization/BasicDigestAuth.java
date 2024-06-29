package BasicAuthorization;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
public class BasicDigestAuth {
	//only username and password in basic auth
	@Test
	public void BasicAuth()
	{
		RequestSpecification requestSpec = RestAssured.given();

		//Specify URL
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");

		//perform get request
		Response response = requestSpec.auth().basic("postman", "password").get();

		//print status line
		System.out.println("Responsne status:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());

	}

	@Test
	public void DigestAuth()
	{
		//http://httpbin.org/digest-auth/auth/prachi/prachi
		RequestSpecification requestSpec = RestAssured.given();

		//Specify URL
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/auth/prachi/prachi");

		//perform get request
		//Response response = requestSpec.get();
		Response response = requestSpec.auth().digest("prachi", "prachi").get();

		Assert.assertEquals(response.statusCode()/*actual*/, 200,"check for status code");
		//print status line
		System.out.println("Digest Auth Responsne status:" + response.statusLine());
		System.out.println("Digest Auth Response body:" + response.body().asString());

	}

}
