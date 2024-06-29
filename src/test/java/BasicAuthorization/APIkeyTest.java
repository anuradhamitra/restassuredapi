package BasicAuthorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIkeyTest {
	//https://api.openweathermap.org/data/2.5/weather?q=delhi&appid=b19fc37eafef974456b559e2e74d440d

		@Test
		public void GetWeatherDataByCity()
		{
			//create request specification
			RequestSpecification requestSpec = RestAssured.given();
			requestSpec.baseUri("https://api.openweathermap.org");
			requestSpec.basePath("/data/2.5/weather");
			requestSpec.queryParam("q", "delhi").queryParam("appid", "b19fc37eafef974456b559e2e74d440d");
			Response response = requestSpec.get();
			//validate status code 
			Assert.assertEquals(response.statusCode()/*actual*/, 200/*expected*/,"check for status code");	
			//print status line & response boy
			System.out.println("Responsne status line:" + response.statusLine());
			System.out.println("Response body:" + response.body().asString());
			

		}
	}
