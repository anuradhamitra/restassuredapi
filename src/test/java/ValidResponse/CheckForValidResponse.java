package ValidResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	//https://reqres.in/api/users/2
	
	
		@Test
		public void GetSingleUser()
		{
			//specify base URL
			RestAssured.baseURI = "https://reqres.in/api/users/19";
			
			//Get Request specification of the request
			//every request in rest assured library is represented by an interface called RequestSpecification
			RequestSpecification requestSpec =  RestAssured.given();
		
			//call get method
			Response response = requestSpec.get();
			
			
			//gets response code
			int statusCode = response.getStatusCode();
			
			//validate actual status code with expected
			
			Assert.assertEquals(statusCode, 200, "Incorrect status code received");	
			String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","Incorrect status line returned");
			
			
		}
		
		@Test
		public void GetSingleUserUsingValidatableResponse()
		{
			//specify base URL
			RestAssured.baseURI = "https://reqres.in/api/users/2";
			
			//Get Request specification of the request
			RequestSpecification requestSpec =  RestAssured.given();
		
			//call get method
			Response response = requestSpec.get();
			
			
			ValidatableResponse validateRes = response.then();
			
			//status code 
		//	validateRes.statusCode(200);
			
		//	System.out.println("second validation");
			//status line
			validateRes.statusLine("HTTP/1.1 200 OK");
			
			
		}
	}
