package RestAssured_2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGetRequest
{

	@Test
	public void testget()
	{
		
		RequestSpecification rs= RestAssured.given();
	//	Response resp= rs.baseUri("https://reqres.in/api/users?page=2").get();
		
		Response resp= rs.get("https://reqres.in/api/users?page=2");
		
		resp.prettyPrint();
		
		System.out.println("======================");
		System.out.println(resp.asString());
		System.out.println(resp.getSessionId());
		System.out.println(resp.getStatusCode());
		System.out.println("done...");
	}
	
}
