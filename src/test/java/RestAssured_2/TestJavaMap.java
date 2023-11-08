package RestAssured_2;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestJavaMap
{

	@Test(enabled=false)
	public void createToken()
	{
		
		Map<String,String> map= new HashMap<>();
		
		map.put("username","admin");
		map.put("password","password123");
		
		RequestSpecification rs= RestAssured.given();


		Response resp= rs.baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON).body(map).post();
		
		//Response resp= RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON).body(map).post();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 200,"status code matched");
		
		System.out.println("done");
	}
	
	@Test
	public void addUser()
	{
		

		/*{
   "firstName":"Amod",
   "lastName":"Mahajan",
   "age": 28,
   "salary": 10000.56,
   "IsMarried":true,
   "Hobbies":["Music","Computer","Games"],
 "TechSkill":{
		"Programming language":"Java",
		"WebAutomation":"Selenium",
		"API testing" : "Rest Assured"
		

             }
   
 }*/

		HashMap<String,Object> map= new HashMap<>();
		
		map.put("firstname", "amit"); // map)
		map.put("lastname", "patil");
		
		map.put("age", 30);
		map.put("salary",25000);
		map.put("ismarrried",false);
		
		List< String> list1= new ArrayList<>();
		
		list1.add("music");
		list1.add("youtube");
		list1.add("cricket");
		
		map.put("Hobbies",list1);
		
		HashMap<String,String> map1= new HashMap<>();
		map1.put("language","java");
		map1.put("ui automation","selenium");
		map1.put("api testing", "Rest API");
		
		map.put("Skills",map1);
		
		
		Response resp= RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(map).post();
				
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 201,"status code not matched");
		
		System.out.println("done...");
		
		
		
		
	}
	
}
