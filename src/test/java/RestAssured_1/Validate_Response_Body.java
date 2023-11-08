package RestAssured_1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Validate_Response_Body 
{

	@Test(enabled=false)
	public void testesponsebody()
	{
		
		Response resp= RestAssured.given().get("https://reqres.in/api/users/2");
		ResponseBody body= resp.getBody();
		String  strbody = body.asString();
		System.out.println("String body: " + strbody);
		
		Assert.assertEquals(strbody.contains("Lindsay"), true, "name is not matched.");
		
		JsonPath path= body.jsonPath();
		String fname= path.get("data[2].first_name");
		Assert.assertEquals(fname, "Janet", "fname not matched");
		System.out.println("done....");
	}
	
	
	@Test
	public void testesponsebody1()
	{
		
		RequestSpecification req= RestAssured.given();
		
		
        Response resp1=	req.get("https://reqres.in/api/users?page=2");
        
        ResponseBody body1=	resp1.getBody();
        String strbody1= body1.asString();
        System.out.println("new body : " + strbody1);
        
        
        Assert.assertEquals(strbody1.contains("George"), true, "name is not matched.");
        
        JsonPath path= body1.jsonPath();
		String fname= path.get("data[4].first_name");
		Assert.assertEquals(fname, "George", "fname not matched");
		System.out.println("done....");
	
	}
}
