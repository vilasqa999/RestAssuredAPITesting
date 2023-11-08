package RestAssured_1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestResponses
{

	@Test
	public void testResponse()
	{
		
		
		RequestSpecification rs= RestAssured.given();
	
		
       Response resp= rs.get("https://restful-booker.herokuapp.com/booking");
       
       System.out.println(resp.asString());
       
       Assert.assertEquals(resp.statusCode(),  200, "status code not matched");
       Assert.assertEquals(resp.statusLine(),"HTTP/1.1 200 OK", "status line not matched");
       //Assert.assertEquals(resp.getTime(),  1958 , "response time");
       Assert.assertEquals(resp.contentType(),  "application/json; charset=utf-8", "content type not match");
       
       System.out.println("done...");
       
       
	}
	
}
