package RestAssured_2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VSLogin 
{

	@Test
	public void testLogin()
	{
	
		JSONObject json= new JSONObject();
		json.put("Email","testingvsbuilder@gmail.com");
		json.put("Pwd", "testing123");
		
		
		RequestSpecification rs= RestAssured.given();
		Response resp = rs.baseUri("https://vssub3.azurewebsites.net/auth/login").contentType(ContentType.JSON).
				body(json.toJSONString()).post();
				
		
		resp.prettyPrint();
	}
}
