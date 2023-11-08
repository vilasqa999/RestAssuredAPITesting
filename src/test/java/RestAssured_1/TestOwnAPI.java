package RestAssured_1;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovyjarjarasm.asm.Type;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestOwnAPI 
{

	@Test (enabled=true)	
	public void readuserdata()
	{
			
		
	//	RequestSpecification rs= RestAssured.given();
		
		//Response resp= rs.baseUri("http://localhost:3000/users").get();
		
		Response resp= RestAssured.given().get("http://localhost:3000/users");
		
		resp.prettyPrint();
		Assert.assertEquals(resp.statusCode(),200, "status code is not matching");
		
		System.out.println("GET method done... ");
		
		
	}
	
	
	
	@Test(enabled=false)
	public void createUserData()
	{
		
		JSONObject json=new JSONObject();
        json.put("user",  "balu giri");
        json.put("age",  35);
        
        
       
        
        Response resp= RestAssured.given().header("Content-type", "Application/json").contentType(ContentType.JSON).body(json.toJSONString()).post("http://localhost:3000/users");
        
        resp.prettyPrint();
        
        Assert.assertEquals(resp.statusCode(),  201, "post status code showing wrong");
        System.out.println("done with post req...");
        
        
	}
	
	@Test (enabled=false)
	public void updateUserData()
	{
		
		JSONObject json=new JSONObject();
        json.put("user",  "balu giri");
        json.put("age",  40);
        
        
       
        
        Response resp= RestAssured.given().header("Content-type", "Application/json").contentType(ContentType.JSON).body(json.toJSONString()).put("http://localhost:3000/users/3");
        
        resp.prettyPrint();
        System.out.println("data updated...");
        
        Assert.assertEquals(resp.statusCode(),  200, "post status code showing wrong");
        System.out.println("done with post req...");
        
        
	}
	
	
	
	@Test	(enabled=false)
	public void deleteUserData()
	{
		
		JSONObject json=new JSONObject();
        json.put("user",  "balu giri");
        json.put("age",  40);
        
        
       
        
        Response resp= RestAssured.given().header("Content-type", "Application/json").contentType(ContentType.JSON).body(json.toJSONString()).delete("http://localhost:3000/users/2");
        
        resp.prettyPrint();
        System.out.println("data deleted...");
        
        Assert.assertEquals(resp.statusCode(),  200, "delete status code showing wrong");
        System.out.println("done with delete req...");
        
        
	}
}
