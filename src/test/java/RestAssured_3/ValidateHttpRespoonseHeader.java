package RestAssured_3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ValidateHttpRespoonseHeader
{
	@Test
	public void testvalidateHttpResponseHeader()
	{
		
		Response resp= RestAssured.given().baseUri("https://reqres.in/api/users/2").get();
		
		String contentType= resp.getHeader("Content-Type");
		System.out.println(contentType);
		
		Assert.assertEquals(contentType,"application/json; charset=utf-8","content type mismatch");
		System.out.println("done...");
		
		System.out.println("print response header...");
		
		Headers header= resp.getHeaders();
		for(Header head:header)
		{
			System.out.println(head.getName() + " " +  head.getValue());
		}
	}
}
