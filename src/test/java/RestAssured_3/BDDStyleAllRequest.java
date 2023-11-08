package RestAssured_3;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BDDStyleAllRequest
{

	@Test (enabled=false)
	public void TestGet()
	{
		
		RestAssured.given().baseUri("https://reqres.in/api/users").queryParam("page","2").
		when().get().
		then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
		
		System.out.println("done...");
	}
	@Test(enabled=false)
	public void postmethod()
	{
		
		JSONObject json= new JSONObject();
		json.put("name",  "amit giri");
		json.put("job",  "manager");
		
		
		
		        RestAssured.given().baseUri("https://reqres.in/api/users").headers("Content-type", "application/json").
				contentType(ContentType.JSON).body(json.toJSONString()).
				when().post().
				then().statusCode(201).log().all();
	}
	
	@Test(enabled=false)
	public void putmethod()
	{
		
		JSONObject json= new JSONObject();
		json.put("name",  "anil giri");
		json.put("job",  "HR");
		
		
		
		        RestAssured.given().baseUri("https://reqres.in/api/users").headers("Content-type", "application/json").
				contentType(ContentType.JSON).body(json.toJSONString()).
				when().put("/2").
				then().statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void patchtmethod()
	{
		
		JSONObject json= new JSONObject();
		json.put("name",  "amit giri");
		json.put("job",  "CEO");
		
		
		
		        RestAssured.given().baseUri("https://reqres.in/api/users").headers("Content-type", "application/json").
				contentType(ContentType.JSON).body(json.toJSONString()).
				when().patch("/2").
				then().statusCode(204).log().all();
	}
	
	@Test (enabled=true)
	public void TestDelete()
	{
		
		RestAssured.given().baseUri("https://reqres.in/api/users/2").
		when().delete().
		then().statusCode(204).log().all();
		
		System.out.println("done...");
	}
	
}
