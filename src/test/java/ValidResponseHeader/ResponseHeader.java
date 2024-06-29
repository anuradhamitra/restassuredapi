package ValidResponseHeader;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseHeader {
	@Test
	public void GetSingleUser()
	{
		//Get Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users/2");
		
		//create get request
		Response response = requestSpec.get();
		
		//validate response header
		String contentType = response.getHeader("Content-Type");
		String connection = response.getHeader("Connection");
		System.out.println("Value of contentType:" + contentType);
		System.out.println("Value of connection:" + connection);
		
		//read all the response header attributes/keys and print their values
		Headers headersList = response.getHeaders();
		
		//iterate over header list 
		for (Header header:headersList)
		{
			System.out.println("Key:"+header.getName() + "Value:" + header.getValue());
		}
		//validate header content-type , expected value : application/json; charset=utf-8
		Assert.assertEquals(contentType, "application/json; charset=utf-8","Header content type matched.");
		Assert.assertEquals(connection, "keep-alive","Connection Alive");
		
	}
	@Test
	public void GetSingleUser1()
	{
		//Get Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users/2");
		
		//create get request
		Response response = requestSpec.get();
		
		//validate response header
		String contentType = response.getHeader("Content-Type");
		System.out.println("Value of contentType:" + contentType);
		//validate header content-type , expected value : application/json; charset=utf-8
		Assert.assertEquals(contentType, "application/json; charset=utf-81","Header content type mismatched.");
		
	}
	
}
