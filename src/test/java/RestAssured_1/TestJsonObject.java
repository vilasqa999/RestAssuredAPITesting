package RestAssured_1;

import java.util.*;


import org.testng.Assert;
import org.testng.annotations.Test;

import groovyjarjarasm.asm.Type;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestJsonObject 
{

	@Test(enabled=false)
	public void testJson()
	{

		
		HashMap<String, String> map= new HashMap<>();
		
		map.put("username","admin");
		map.put("password", "password123");
		
		
		Response resp= RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").
	    contentType(ContentType.JSON).body(map).post();
		System.out.println(resp);
		
		Assert.assertEquals(resp.statusCode(), 200 , "status code wrong..");
		
	}
	
	
	
/*		

{
"firstName":"Anil",
"lastName":"mali",
"age": 30,
"salary": 10000.56,
"IsMarried":true,
"Hobbies":["Music","Computer","Games"],
"TechSkill":{
	"Programming language":"Java",
	"WebAutomation":"Selenium",
	"API testing" : "Rest Assured"
	

         }

}
	*/
	
	@Test	
	public void testCreateUser()
	{
		
		
		HashMap<String, Object> map= new HashMap<>();
		
		map.put("firstName","Amit");
		map.put("lastName", "Patil");
		map.put("age", 30);
		map.put("salary", 70000);
		map.put("IsMarried", false);
		
		ArrayList al =new ArrayList();
		al.add("cricket");
		al.add("god");
		al.add("music");
		
		map.put("Hobbies", al);
		
		        Response resp= RestAssured.given().baseUri("https://reqres.in/api/users").
			    contentType(ContentType.JSON).body(map).post();
				System.out.println(resp);
				
				Assert.assertEquals(resp.statusCode(), 201 , " status code wrong..");
				System.out.println("user create succesffully..............");
		
	}
}


