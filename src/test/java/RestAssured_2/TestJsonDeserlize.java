package RestAssured_2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestJsonDeserlize 
{

	
	@Test
	public void TestJsonDeserlize()
	{
		
		JSONObject json= new JSONObject();
		json.put("name",  "amit patil");
		json.put("job",  "HR");
		
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(json.toJSONString()).post();
		
		resp.prettyPrint();
		
		ResponseBody body=resp.getBody();
		
		TestJsonResponse jsontoobject= body.as(TestJsonResponse.class);
		
		Assert.assertEquals(jsontoobject.name, "amit patil", "name not matched");
		Assert.assertEquals(jsontoobject.job, "HR", "job not matched");
		
	}
	
}
