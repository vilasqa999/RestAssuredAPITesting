package RestAssured_3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest
{

	@Test
	public void getMethod()
	{
		
		
		Response resp= RestAssured.given().get("https://reqres.in/api/users?page=2");
		
		resp.prettyPeek();
		//resp.prettyPrint();
		//System.out.println(resp.asString());
		//System.out.println(resp.statusCode());
		
		Assert.assertEquals(resp.statusCode(),200, "status code not matched");
		System.out.println("done");
	}
	
	
	
}
