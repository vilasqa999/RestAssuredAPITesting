package RestAssured_2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestRestRequestWithBDD
{

	
	
	@Test(enabled=false)
	public void testget()
	{
		
		
		RequestSpecification rs= RestAssured.given();
		Response resp= rs.get("https://reqres.in/api/users?page=2");
		
		
		System.out.println("status code:" + resp.statusCode());
		System.out.println("Response time:" + resp.getTime());
		System.out.println("response body:" + resp.getBody().asString());
		System.out.println("header: " + resp.getHeader("Content-Type"));
		
	}
	
	@Test (enabled=false)
	public void getRequest()
	{
		
		RestAssured.given().baseUri("https://reqres.in/api/users").queryParam("page","2").
		when().get().
		then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
		
	}
	
	@Test	(enabled=false)
	public void postRequest()
	{
		
		JSONObject json= new JSONObject();
		json.put("name","amit giri");
		json.put("job", "manager");
		
		
		RestAssured.given().baseUri("https://reqres.in/api/users").header("Content-Type", "application/json").contentType(ContentType.JSON).body(json.toJSONString(json)).
		when().post().
		then().statusCode(201).log().all();
		System.out.println("done");
	}
	
	@Test
	public void TestnormalPost()
	{
		
		JSONObject json= new JSONObject();
		json.put("name","amit giri");
		json.put("job", "manager");
		
		
		RequestSpecification rs= RestAssured.given();
		Response resp= rs.baseUri("https://reqres.in/api/users").header("Content-Type","application/json").contentType(ContentType.JSON).body(json.toJSONString()).post();
		
		resp.prettyPrint();
		System.out.println(resp.statusCode());
		System.out.println(resp.getBody().asString());
		System.out.println("normal done");
		
	}
}
