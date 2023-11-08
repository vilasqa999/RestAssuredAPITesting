package RestAssured_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.entity.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestJsonArray_JsonObject_List 
{

	@Test(enabled=false)	
	public void testJsonArrayusingJsonObject()
	{
		
		JSONObject user1=new  JSONObject();
		user1.put("firstname", "amit");
		user1.put("lastname", "giri");
		user1.put("city", "pune");
		user1.put("picode",  "123456");
		
		
		JSONObject user2=new  JSONObject();
		user2.put("firstname", "balu");
		user2.put("lastname", "puri");
		user2.put("city", "latur");
		user2.put("picode",  "456123");
		
		JSONObject user3=new  JSONObject();
		user3.put("firstname", "chetan");
		user3.put("lastname", "puri");
		user3.put("city", "beed");
		user3.put("picode",  "456674");
		
		JSONObject user4=new  JSONObject();
		user4.put("firstname", "dagadu");
		user4.put("lastname", "bharati");
		user4.put("city", "kanpur");
		user4.put("picode",  "443356");
		
		
		JSONArray arr= new JSONArray();
		arr.add(user1);
		arr.add(user2);
		arr.add(user3);
		
		arr.add(user4);
		
		
		
		Response resp= RestAssured.given().baseUri("https://reqres.in/api/users").contentType(io.restassured.http.ContentType.JSON).body(arr).post();
		resp.prettyPeek();
		
		Assert.assertEquals(resp.statusCode(), 201,"not matched");
		System.out.println("done...");
	}
	
	
	@Test	
	public void testJsonArrayusingList()
	{
		
		HashMap<String,String> user1=new  HashMap<>();
		user1.put("firstname", "amit");
		user1.put("lastname", "giri");
		user1.put("city", "pune");
		user1.put("picode",  "123456");
		
		
		HashMap<String,String> user2=new  HashMap<>();
		user2.put("firstname", "balu");
		user2.put("lastname", "puri");
		user2.put("city", "latur");
		user2.put("picode",  "456123");
		
		HashMap<String,String> user3=new  HashMap<>();
		user3.put("firstname", "chetan");
		user3.put("lastname", "puri");
		user3.put("city", "beed");
		user3.put("picode",  "456674");
		
		HashMap<String,String> user4=new  HashMap<>();
		user4.put("firstname", "dagadu");
		user4.put("lastname", "bharati");
		user4.put("city", "kanpur");
		user4.put("picode",  "443356");
		
		
		List<Map<String,String>> list=new ArrayList<>();
		
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		list.add(user4);
		
		
		
		Response resp= RestAssured.given().baseUri("https://reqres.in/api/users").contentType(io.restassured.http.ContentType.JSON).body(list).post();
		resp.prettyPeek();
		
		Assert.assertEquals(resp.statusCode(), 201,"not matched");
		System.out.println("done...");
	}
}
