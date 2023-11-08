package RestAssured_3;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBearerToken 
{

	@Test
	public void testBearerToken()
	{
		
		String bearertoken= "Bearer 24e7c2fe384a85176a576823e88b275f74ef12eb4fab338b8798da6b3a998a9a";
		JSONObject json= new JSONObject();
		json.put("name","amitt");
		json.put("email", "hr1232@gmai.com");
		json.put("gender",  "male");
		json.put("status", "active");
		
	//	RequestSpecification rs=RestAssured.given();
		
		Response resp= RestAssured.given().baseUri("https://gorest.co.in/public/v2/users").headers("Authorization",bearertoken).
		contentType(ContentType.JSON).body(json.toJSONString()).post();
		
		resp.prettyPrint();
		
		System.out.println(resp.statusCode());
		System.out.println("done...");
		
		
		
		
	}
}

