package RestAssured_1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Validate_Response_Header 
{
	@Test
	public void testHeader()
	{
		
		

		
		Response resp= RestAssured.given().get("https://reqres.in/api/users/2");
		String contenttype= resp.getHeader("Content-Type");
		Assert.assertEquals(contenttype,  "application/json; charset=utf-8", "incoorect content type coming");
		
		System.out.println("====================================");
		
		Headers header= resp.getHeaders();
		for(Header h:header)
		{
			System.out.println(h.getName() + " : " + h.getValue());
		}
		
	}

}
