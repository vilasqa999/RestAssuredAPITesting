package RestAssured_2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestDeleteRequest 
{

	@Test(enabled=false)
	public void testDelete()
	{
		
		RestAssured.given().baseUri("https://reqres.in/api/users/295").when().delete().then().statusCode(204).log().all();
		System.out.println("done  for delete with bdd");
	}
	
	
	@Test
	public void testnormalDelete()
	{
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://reqres.in/api/users/295").delete();
		resp.prettyPrint();
		
		System.out.println("status code: " + resp.statusCode());
		System.out.println("body:" + resp.body().asString()); 
		
		System.out.println("done normal way");
		
		
	}
}
