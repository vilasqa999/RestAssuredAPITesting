package RestAssured_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_Delete_Method 
{

	@Test	
	public void testdelete()
	{
		
		
		RestAssured.baseURI= "https://reqres.in/api/users/2";
		
		
		RestAssured.given().when().delete().then().statusCode(204).log().all();
		System.out.println("done...");
	}
	
}
