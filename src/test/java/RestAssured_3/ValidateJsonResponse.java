package RestAssured_3;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponse 
{
	@Ignore
	@Test	
	public void validateJsonResponse()
	{
		RequestSpecification rs= RestAssured.given();
		
		Response resp=rs.given().baseUri("https://reqres.in/api/users?page=2").get();
		
		ResponseBody body= resp.getBody();
        String name1=		body.asString();
		resp.prettyPrint();
		System.out.println(name1.contains("Janet"));
		
		JsonPath path= body.jsonPath();
		String name= path.get("data[4].first_name");
		Assert.assertEquals(name,  "Charles", "name not matched");
		
	}
	
	
	
	
	@Test	
	public void validateHttpjson()
	{
		
		
		//Response resp=RestAssured.given().baseUri("https://reqres.in/api/users?page=2").get();

		Response resp=RestAssured.given().baseUri("https://reqres.in/api/users").queryParam("page","2").get();
		ResponseBody body =resp.getBody();
		
		String name2= body.asString();
		System.out.println(name2.contains("Michael"));
		
		JsonPath path= body.jsonPath();
		String name=path.get("data[2].last_name");
		Assert.assertEquals(name, "Funke", "not matched");
		System.out.println("done");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
