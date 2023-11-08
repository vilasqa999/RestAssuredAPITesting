package RestAssured_2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPutRequest 
{

	@Test (enabled=false)	
	public void testPut()
	{
		
		
		JSONObject json=new JSONObject();
		
		json.put("name", "Balu giri");
		json.put("job",  "daily engineer");
		
		RestAssured.given().baseUri("https://reqres.in/api/users/295").header("Content-Type", "application/json").contentType(ContentType.JSON)
	    .body(json.toJSONString()).when().put().then().statusCode(200).log().all();
		
		System.out.println("done with bdd...");
	   
	
	}
	
	@Test	
	public void testnormalPut()
	{
		
		
		JSONObject json=new JSONObject();
		
		json.put("name", "Ashok giri");
		json.put("job",  "Mech engineer");
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp =rs.baseUri("https://reqres.in/api/users/295").header("Content-Type", "application/json").contentType(ContentType.JSON)
	    .body(json.toJSONString()).put();
		
	    
		resp.prettyPrint();
		System.out.println("body:" + resp.body().asString());
		System.out.println("status code:" + resp.statusCode());
		
		System.out.println("done with normal way...");
	   
	
	}
	
	
	
	
}
