package RestAssured_2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBearerToken 
{

	@Test(enabled=false)
	public void testbearerToken()
	{
		
		
		
		JSONObject json= new JSONObject();
		json.put("name", "Vilas giriii");
		json.put("gender",  "male");
		json.put("email", "amitpuri.@15ece.com");
		json.put("status",  "active");
		
		
		String bearertoken= "Bearer e7ecd112b738483724ca6e335ceb193ac46f52f9ef63e9fe3be530f994f13e23";
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://gorest.co.in/public/v2/users").
				headers("Authorization", bearertoken).contentType(ContentType.JSON).body(json.toJSONString()).post();
		resp.prettyPrint();
		
		System.out.println("done");
		
	}
	
	
	
	@Test
	public void testBearer2()
	{
		
		
		
		JSONObject json= new JSONObject();
		
		json.put("name", "amittt giriitti");
		json.put("gender",  "male");
		json.put("email", "ganerteshfast@15ece.com");
		json.put("status",  "active");
		
		
		String bearerToken= "Bearer e7ecd112b738483724ca6e335ceb193ac46f52f9ef63e9fe3be530f994f13e23";
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://gorest.co.in/public/v2/users").headers("Authorization", bearerToken).contentType(ContentType.JSON).body(json.toJSONString()).post();
		
		resp.prettyPeek();
		resp.prettyPrint();
		System.out.println("done by v");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
