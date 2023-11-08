package RestAssured_2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateHttpResponse 
{

	@Test(enabled=false)
	public void verifyResponse()
	{
		 
		
		RequestSpecification rs= RestAssured.given();
		
		
       Response resp= rs.baseUri("https://reqres.in/api/users?page=2").get();
       
      //       System.out.println();
       resp.prettyPrint();
       
       Assert.assertEquals(resp.statusCode(),  200, "status code not matched");
       Assert.assertEquals(resp.statusLine(),  "HTTP/1.1 200 OK", "status line not matched");
       System.out.println("response verify...");
       
	}
	
	@Test
	public void verifyResponseusingbdd()
	{
		 
		
		//RequestSpecification rs=
		
		 RestAssured.given().baseUri("https://reqres.in/api/users?page=2").when().get().then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
		
      
       System.out.println("response verify...");
       
	}
}
