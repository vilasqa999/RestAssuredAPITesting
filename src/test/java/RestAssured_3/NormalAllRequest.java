package RestAssured_3;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NormalAllRequest
{

	@Test (enabled=false)
	public void testGetmethod()
	{
		
		Response resp= RestAssured.get("https://reqres.in/api/users?page=2");
		
		resp.prettyPrint();
        System.out.println(resp.statusCode());		
        System.out.println(resp.statusLine());		
        System.out.println(resp.asString());
        
        Assert.assertEquals(resp.statusCode(),200, "not matched");
		System.out.println("get method done...");
	}
	

	@Test(enabled=false)
	public void testPostmethod()
	{
		
		
		          JSONObject json= new JSONObject();
		          json.put("name",  "amit giri");
		          json.put("job",  "manager");
		
		
		
		        Response resp1 =  RestAssured.given().baseUri("https://reqres.in/api/users").headers("Content-type", "application/json").
				contentType(ContentType.JSON).body(json.toJSONString()).post();
		       
		        resp1.prettyPrint();
		        System.out.println(resp1.statusCode());
		        Assert.assertEquals(resp1.statusCode(),201,"status code not matched");
		        
		        System.out.println("post method done....");
	}
	
	
	@Test(enabled=false)
	public void testPutmethod()
	{
		
		
		          JSONObject json= new JSONObject();
		          json.put("name",  "amol giri");
		          json.put("job",  "hr");
		
		
		
		        Response resp1 =  RestAssured.given().baseUri("https://reqres.in/api/users/2").headers("Content-type", "application/json").
				contentType(ContentType.JSON).body(json.toJSONString()).put();
		       
		        resp1.prettyPrint();
		        System.out.println(resp1.statusCode());
		        Assert.assertEquals(resp1.statusCode(),200,"status code not matched");
		        
		        System.out.println("put method done....");
	}
	
	
	@Test(enabled=false)
	public void testPatchmethod()
	{
		
		
		          JSONObject json= new JSONObject();
		          json.put("name",  "amol giri");
		          json.put("job",  "ceo");
		
		
		
		        Response resp1 =  RestAssured.given().baseUri("https://reqres.in/api/users/2").headers("Content-type", "application/json").
				contentType(ContentType.JSON).body(json.toJSONString()).patch();
		       
		        resp1.prettyPrint();
		        System.out.println(resp1.statusCode());
		        Assert.assertEquals(resp1.statusCode(),200,"status code not matched");
		        
		        System.out.println("patch method done....");
	}
	

	@Test(enabled=true)
	public void testdeletemethod()
	{
		
		
		         
		
		
		
		        Response resp1 =  RestAssured.given().baseUri("https://reqres.in/api/users/2").delete();
		       
		        resp1.prettyPrint();
		        System.out.println(resp1.statusCode());
		        Assert.assertEquals(resp1.statusCode(),204,"status code not matched");
		        
		        System.out.println("delete method done....");
	}
}
