package RestAssured_1;

//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
//import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test_API_Key1 
{

	
	@Test(enabled=false)
	public void testAPI()
	{
		
		
		RequestSpecification rs= RestAssured.given();
		rs.queryParam("q","Delhi").queryParam("appid","60148a09047d13dc38d9342b8e9764b6");
		
		Response resp1= rs.get();
        ResponseBody res= resp1.body();
		System.out.println("status line: " + resp1.statusLine());
		//Assert.assertEquals(resp.statusCode(),  200, "API key not valid");
		System.out.println("response body: " + res.asString());
		
		System.out.println("done....");
	}
	


	@Test
	public void testAPIKey()
	{
		RequestSpecification rs= RestAssured.given();
		rs.queryParam("q","Delhi").queryParam("appid","60148a09047d13dc38d9342b8e9764b6");
		Response resp= rs.get();
		System.out.println("status line: " + resp.statusLine());
		System.out.println("response body: " + resp.body().asString());
	    System.out.println("done....");
	}
	
}
