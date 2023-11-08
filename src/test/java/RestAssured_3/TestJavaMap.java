package RestAssured_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestJavaMap
{

	@Test	
	public void testJavaMap()
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

		HashMap<String,Object> map=new HashMap<>();
		
		map.put("firstname", "amit");
		map.put("lastname","giri");
		map.put("age", "30");
		map.put("salary", "20000");
		map.put("ismarried","false");
		
		List<String> list=new ArrayList<>();
		
		list.add("cricket");
		list.add("computer");
		list.add("youtube");

		map.put("hobbies",list);
		
		
		Response resp=RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(map).post();
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),201,"not matched");
		
		
	}
	
}
