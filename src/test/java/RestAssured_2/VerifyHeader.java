package RestAssured_2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyHeader 
{
	@Test
	public void verifyHeaders()
	{
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://reqres.in/api/users?page=2").get();
		resp.prettyPrint();
		
		//resp.
		Headers head=resp.getHeaders();
		
		Assert.assertEquals(resp.contentType(),  "application/json; charset=utf-8", "content tyep misatch");
		for(Header h:head)
		{
			
			System.out.println("key :" + h.getName() + "value: " +  h.getValue());
			
			
		}
	}
	
}
