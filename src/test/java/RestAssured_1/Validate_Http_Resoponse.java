package RestAssured_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Validate_Http_Resoponse 
{

	@Test
	public void test_validate_response()
	{
		
		
		RestAssured.baseURI= "https://reqres.in/api/users/2";
		
		RequestSpecification request= RestAssured.given();
		
		Response resp= request.get();
		
		int  statuscode= resp.getStatusCode();
		
		Assert.assertEquals(statuscode,200);
		
		String statusline= resp.getStatusLine();
		
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
		
	}
	
	@Test
	
	public void test_validate_BDD()
	{
		System.out.println("==========================================");
		//RestAssured.baseURI= "https://reqres.in/api/users/2";
		RestAssured.given().when().get("https://reqres.in/api/users/2").then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
	}
}
