package RestAssured_3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_API_Key
{

	@Test
	public void getWheatherData()
	{
		
		Response resp= RestAssured.given().baseUri("https://api.openweathermap.org/data/2.5/weather").queryParam("q","pune").queryParam("appid","60148a09047d13dc38d9342b8e9764b6").get();
		resp.prettyPrint();
		System.out.println(resp.statusCode());
		System.out.println("done...");
	}
}
