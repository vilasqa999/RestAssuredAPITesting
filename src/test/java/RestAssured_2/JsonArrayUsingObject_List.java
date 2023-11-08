package RestAssured_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonArrayUsingObject_List
{

	@Test	(enabled=false)
	public void  UserArray1()
	{
	
		
		JSONObject user1= new JSONObject();
		
		 user1.put("firstname",  "amit");
		 user1.put("lastname", "giri");
		 user1.put("age",  28);
		 user1.put("salary", 25000);
		 user1.put("ismarried", "no");
		 
		 
		 JSONObject user2= new JSONObject();
			
		 user2.put("firstname",  "balu");
		 user2.put("lastname", "giri");
		 user2.put("age",  25);
		 user2.put("salary", 26000);
		 user2.put("ismarried", "no");
		 
		 JSONObject user3= new JSONObject();
			
		 user3.put("firstname",  "chandu");
		 user3.put("lastname", "giri");
		 user3.put("age",  30);
		 user3.put("salary", 2000);
		 user3.put("ismarried", "no");
		 
		 JSONObject user4= new JSONObject();
			
		 user4.put("firstname",  "dagadu");
		 user4.put("lastname", "giri");
		 user4.put("age",  30);
		 user4.put("salary", 23500);
		 user4.put("ismarried", "no");
		 
		 
		 
		 JSONArray userarray= new JSONArray();
		 
		 userarray.add(user1);
		 userarray.add(user2);
		 userarray.add(user3);
		 userarray.add(user4);
		 
		 
		 Response resp= RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(userarray).post();
		 
		 resp.prettyPrint();
		 
		 Assert.assertEquals(resp.statusCode(),201,"status code not matched");
		 
		 System.out.println("done with json array...");
		 
	}
	
	
	@Test	
	public void  UserArrayusingList()
	{
	
		
		Map<String, Object> map1=new HashMap<>();
		
		map1.put("firstname",  "amit");
		map1.put("lastname", "giri");
		map1.put("age",  28);
		map1.put("salary", 25000);
		map1.put("ismarried", "no");
		 
		 
		Map<String, Object> map2=new HashMap<>();
			
		 map2.put("firstname",  "balu");
		 map2.put("lastname", "giri");
		 map2.put("age",  25);
		 map2.put("salary", 26000);
		 map2.put("ismarried", "no");
		 
		 Map<String, Object> map3=new HashMap<>();
			
		 map3.put("firstname",  "chandu");
		 map3.put("lastname", "giri");
		 map3.put("age",  30);
		 map3.put("salary", 2000);
		 map3.put("ismarried", "no");
		 
		 Map<String, Object> map4=new HashMap<>();
			
		 map4.put("firstname",  "dagadu");
		 map4.put("lastname", "giri");
		 map4.put("age",  30);
		 map4.put("salary", 23500);
		 map4.put("ismarried", "no");
		 
		 List<Map<String, Object>> list= new ArrayList();
		 
		 //JSONArray userarray= new JSONArray();
		 
		 list.add(map1);
		 list.add(map2);
		 list.add(map3);
		 list.add(map4);
		 
		 
		 Response resp= RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(list).post();
		 
		 resp.prettyPrint();
		 
		 Assert.assertEquals(resp.statusCode(),201,"status code not matched");
		 
		 System.out.println("done with list...");
		 
	}

}
