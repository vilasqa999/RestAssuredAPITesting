package RestAssured_1;

import java.util.ArrayList;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJSONArray
{

	@Test(enabled=false)
	public void TestCreateJsonArray()
	{
		
		
		JSONObject user1=new JSONObject();
		
		user1.put("firstname" , "amit");
		user1.put("lastname" , "giri");
		user1.put("age" , 30);
		user1.put("salary" , 70000);
		
        JSONObject user2=new JSONObject();
		
		user2.put("firstname" , "amar");
		user2.put("lastname" , "giri");
		user2.put("age" , 30);
		user2.put("salary" , 70000);
		
		JSONObject user3=new JSONObject();
		user3.put("firstname" , "sgar");
		user3.put("lastname" , "giri");
		user3.put("age" , 30);
		user3.put("salary" , 70000);
		
		JSONArray userarray=  new JSONArray();
		userarray.add(user1);
		userarray.add(user2);
		userarray.add(user3);
		
		
		RequestSpecification rs= RestAssured.given();
		
		
		Response resp= rs.baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(userarray).post();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),201, "status code not matched");
		
		
		
		
	}
	
	@Test	
	
	public void TestJsonArrayUsingList()
	{
		
		
		
		HashMap<String, Object> user1=new HashMap<>();
		
		user1.put("firstname" , "amit");
		user1.put("lastname" , "giri");
		user1.put("age" , 30);
		user1.put("salary" , 70000);
		
		HashMap<String, Object> user2=new HashMap<>();
		
		user2.put("firstname" , "amar");
		user2.put("lastname" , "giri");
		user2.put("age" , 30);
		user2.put("salary" , 70000);
		
		HashMap<String, Object> user3=new HashMap<>();
		user3.put("firstname" , "sgar");
		user3.put("lastname" , "giri");
		user3.put("age" , 30);
		user3.put("salary" , 70000);
		
		List<Map<String, Object>> userarray= new ArrayList<>();
		
	//	JSONArray userarray=  new JSONArray();
		
		userarray.add(user1);
		userarray.add(user2);
		userarray.add(user3);
		
		
		RequestSpecification rs= RestAssured.given();
		
		
		Response resp= rs.baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(userarray).post();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),201, "status code not matched");
		
		System.out.println("testing using hashmap done.....");
		
	}
	
}
