package RestAssured_2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateOwnAPI 
{
	@Test(enabled=false)
	public void getUserdata()
	{
		
		
		Response resp =RestAssured.given().baseUri("http://localhost:3000/users").get();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 200, "status code not matched");
		
		System.out.println("done with get req...");
	}
	
	
	@Test(enabled=false)	
	public void CreateUserdata()
	{
		
		JSONObject json=new JSONObject();
		json.put("id", 3);
		json.put("name", "dagdu giri");
		json.put("age", 34);
		
		Response resp =RestAssured.given().baseUri("http://localhost:3000/users").headers("Content-type", "application/json").
				contentType(ContentType.JSON).body(json.toJSONString()).post();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 201, "status code not matched");
		
		System.out.println("done with post req...");
	}
	
	

	@Test(enabled=false)	
	public void updateUserdata()
	{
		
		JSONObject json=new JSONObject();
		json.put("id", 3);
		json.put("name", "chandu giri");
		json.put("age", 40);
		
		Response resp =RestAssured.given().baseUri("http://localhost:3000/users/3").headers("Content-type", "application/json").
				contentType(ContentType.JSON).body(json.toJSONString()).put();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 200, "status code not matched");
		
		System.out.println("done with put req...");
	}
	
	

	@Test(enabled=true)
	public void deleteUserdata()
	{
		
		Response resp =RestAssured.given().baseUri("http://localhost:3000/users/3").delete();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 200, "status code not matched");
		
		System.out.println("done with delete req...");
	}
		
	
}
