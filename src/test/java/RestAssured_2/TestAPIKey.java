package RestAssured_2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAPIKey
{

	@Test
	public void testAPIKey()
	{
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://api.openweathermap.org/data/2.5/weather").queryParam("q",  "Mumbai").queryParam("appid", "60148a09047d13dc38d9342b8e9764b6").get();
		
		resp.prettyPrint();
		
		System.out.println("done...");
		
		
		
		
	}
		
		
		
	}
	
