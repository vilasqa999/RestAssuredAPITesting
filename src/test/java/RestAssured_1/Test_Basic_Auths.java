package RestAssured_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_Basic_Auths 
{
	
	@Test
	public void testbasicAuth()
	{
		
		
		RequestSpecification req= RestAssured.given();
		//req.baseUri("https://postman-echo.com/");
	//	req.basePath("/basic-auth");
		
		
		Response resp= req.auth().basic("postman", "password").get("https://postman-echo.com/basic-auth");
		
		System.out.println("status code: " +  resp.statusLine());
		System.out.println("body: " +  resp.body().asString());
		
	}
	
	
	@Test
	public void testDigestAuth()
	{
		
		
		RequestSpecification req= RestAssured.given();	
		Response resp= req.auth().digest("postman", "password").get("https://postman-echo.com/basic-auth");
		System.out.println("==========================================");
		System.out.println("digest status code: " +  resp.statusLine());
		System.out.println("digest body: " +  resp.body().asString());
		
	}
	
	
}
