package QueryParameter;
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
public class QueryParameterTest {
	@Test
	public void filterData()
	{
		//Get Request Specification for the given request
		RequestSpecification requestSpec = RestAssured.given();
		//specify url
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		//query parameter starts with question mark?
		requestSpec.queryParam("page", 2).queryParam("id", 10);
		//query details from request specification
		
		//perform get request
		Response response =requestSpec.get();
		//read response body
		String responseBodyString = response.getBody().asString();
		//print response body
		System.out.println("Response body:" + responseBodyString );
		
		//get json path view of response body
		JsonPath jsonPathView = response.jsonPath();
		//get first_name
		//x.data.first_name
		String firstname = jsonPathView.get("data.first_name");
		Assert.assertEquals(firstname,"Byron","Verify firstname.");
	}
}