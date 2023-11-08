package RestAssured_1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Test_Query_Parameter
{

	@Test
	public void testqueryParemeter1()
	{
		
		RequestSpecification req= RestAssured.given();
		
		req.baseUri("https://reqres.in");
		req.basePath("api/users");
		req.queryParam("page",2).queryParam("id", 7);
        Response resp1=	req.get();
        
        ResponseBody body1=	resp1.getBody();
        String strbody1= body1.asString();
        System.out.println("new body : " + strbody1);
        
        
        Assert.assertEquals(strbody1.contains("Michael"), true, "name is not matched.");
        
        JsonPath path= body1.jsonPath();
		String fname= path.get("data.first_name");
		Assert.assertEquals(fname, "Michael", "fname not matched");
		System.out.println("done....");
	
	}
}
