package RestAssured_2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ValidateJsonResponse
{
	@Test
	public void validateResponse()
	{
		
		
		Response resp= RestAssured.given().get("https://reqres.in/api/users?page=2");
		
		ResponseBody body= resp.getBody();
		
		//String respbody= body.asString();
		
		//Assert.assertEquals(respbody.contains("Lindsay"), true);
		
	//	System.out.println("done...");
		
		System.out.println("=======================================");
		
		
		JsonPath path= body.jsonPath();
		
		String name= path.get("data[4].first_name");
		
		Assert.assertEquals(name.equals("George"), true);
		System.out.println("test case pass....");
		
	}
}
