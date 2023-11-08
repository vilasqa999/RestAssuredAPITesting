package RestAssured_3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Basic_Auth
{
	@Test
	public void testBasicAuth()
	{
		
		//Response resp= RestAssured.given().baseUri("https://postman-echo.com/basic-auth").auth().basic("postman","password").get();
		
		Response resp1= RestAssured.given().baseUri("https://httpbin.org/basic-auth/foo/bar").auth().basic("foo","bar").get();
		resp1.prettyPeek();
		System.out.println(resp1.statusCode());
		System.out.println("done basic auth...");
	}
	
	@Test
	public void testDigetAuth()
	{
		
		Response resp= RestAssured.given().baseUri("https://reqres.in/api/users?page=2").auth().digest("vilas","vilas").get();
		resp.prettyPeek();
		System.out.println(resp.statusCode());
		System.out.println("done basic auth...");
	}
}
