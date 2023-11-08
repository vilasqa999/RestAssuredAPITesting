package RestAssured_3;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestDeserlizeJson 
{
	@Test	
	public void TestSerlizejson()
	{
		
		JSONObject json=new JSONObject();
		json.put("name","amit");
		json.put("job", "hr");
		
		
		Response resp= RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(json.toJSONString()).post();
		
		ResponseBody body= resp.getBody();
		
		TestDeslizeClass t1= body.as(TestDeslizeClass.class);
		
		Assert.assertEquals(t1.name, "amit","not matched");;
		System.out.println("done ...");
		
	}
}
