package RestAssured_3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateHttpResponse
{

	@Test
	public void TestHttpResponseNormalWay()
	{
		
		
		Response resp= RestAssured.given().get("https://reqres.in/api/users/2");
		
	    int actualcode=	resp.statusCode();
	    resp.prettyPrint();
	    Assert.assertEquals(actualcode,  200, "code not matched");
	    Assert.assertEquals(resp.statusLine(), "HTTP/1.1 200 OK" ,"not matched");
	
	}
	
	@Test
	public void TestHttpResponseAnotherway()
	{
		
	   RestAssured.given().baseUri("https://reqres.in/api/users/2").when().get().then().statusCode(200).log().all();
   
	}
	
}


  
