package RestAssured_2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBasicAuth 
{

	@Test	
	public void testBasicAuth()
	{
		
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://postman-echo.com/basic-auth").auth().basic("postman","password").get();
		resp.prettyPrint();
		System.out.println("done");
	}
}
