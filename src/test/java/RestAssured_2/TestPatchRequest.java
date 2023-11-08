package RestAssured_2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPatchRequest 
{
	

	@Test (enabled=false)	
	public void testPatch()
	{
		
		
		JSONObject json=new JSONObject();
		
		json.put("name", "Ramesh giri");
		json.put("job",  "Civil engineer");
		
		RestAssured.given().baseUri("https://reqres.in/api/users/295").header("Content-Type", "application/json").contentType(ContentType.JSON)
	    .body(json.toJSONString()).when().patch().then().statusCode(200).log().all();
		
		System.out.println("done with bdd patch...");
	   
	
	}
	
	@Test	(enabled=true)	
	public void testnormalpatch()
	{
		
		
		JSONObject json=new JSONObject();
		
		json.put("name", "Vilas giri");
		json.put("job",  "Computer engineer");
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp =rs.baseUri("https://reqres.in/api/users/295").header("Content-Type", "application/json").contentType(ContentType.JSON)
	    .body(json.toJSONString()).patch();
		
	    
		resp.prettyPrint();
		System.out.println("body:" + resp.body().asString());
		System.out.println("status code:" + resp.statusCode());
		
		System.out.println("done with normal way for patch...");
	   
	
	}
	

}
