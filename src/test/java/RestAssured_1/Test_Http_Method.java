package RestAssured_1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_Http_Method 
{

	@Test
	public void test_Get()
	{
		
			
			RestAssured.baseURI="https://reqres.in/api/users";
			RestAssured.given().queryParam("page", "2").
			when().get().then().statusCode(200).log().all();
	
			 System.out.println("done with get...");
			 System.out.println("================================================");
   }
	
	@Test(priority=1)
	public void test_Post()
	{
		
			
		   JSONObject json=new JSONObject();
		   
		   json.put("name","amit");
		   json.put("job",  "QA");
		   
		   
		   RestAssured.baseURI= "https://reqres.in/api/users";
		   
		   RestAssured.given().header("content-type", "application/json")
		   .contentType(ContentType.JSON).body(json.toJSONString()).when().post().then().statusCode(201).log().all();
		   
			
		   System.out.println("done with Post...");
		   System.out.println("================================================");
   }
	
	
	@Test(priority=2)
	public void test_Put()
	{
		
			
		   JSONObject json=new JSONObject();
		   
		   json.put("name","amar");
		   json.put("job",  "Manager");
		   
		   
		   RestAssured.baseURI= "https://reqres.in/api/users/696";
		   
		   RestAssured.given().header("content-type", "application/json")
		   .contentType(ContentType.JSON).body(json.toJSONString()).when().put().then().statusCode(200).log().all();
		   
			
		   System.out.println("done with Put...");
		   System.out.println("================================================");
   }
	
	

	@Test(priority=3)
	public void test_Patch()
	{
		
			
		   JSONObject json=new JSONObject();
		   
		   json.put("name","amar");
		   json.put("job",  "teacher");
		   
		   
		   RestAssured.baseURI= "https://reqres.in/api/users/2";
		   
		   RestAssured.given().header("content-type", "application/json")
		   .contentType(ContentType.JSON).body(json.toJSONString()).when().patch().then().statusCode(200).log().all();
		   
			
		   System.out.println("done with Patch...");
		   System.out.println("================================================");
   }
	

	@Test(priority=4)
	public void test_Delete()
	{
		
			
		  
		   
		   RestAssured.baseURI= "https://reqres.in/api/users/2";
		   
		   RestAssured.given().when().delete().then().statusCode(204).log().all();
		   
			
		   System.out.println("done with delete...");
		   System.out.println("================================================");
   }
}
