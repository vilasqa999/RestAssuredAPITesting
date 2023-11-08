import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest 
{

	@Test
	public void CheckGet()
	{
		
		
		Response res= RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println("json data: " + res.asString());
		System.out.println("resoponse code: " + res.getStatusCode());
		
		
	}
	
}
