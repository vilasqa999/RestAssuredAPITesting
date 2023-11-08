package RestAssured_1;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Test_Deserielize_JsonData 
{

	@Test
	public void testDeserilze()
	{
		
		
		RequestSpecification rs= RestAssured.given();
		rs.baseUri("https://reqres.in/");
		rs.basePath("api/users");
		
		
	    JSONObject json=new JSONObject();
	    json.put("name", "amit");
	    json.put("job","Manager");
	    
	    
	    Response resp=  rs.contentType(ContentType.JSON).body(json.toJSONString()).post();
	    
	    ResponseBody body= resp.getBody();
	    
	    Test_Object_Class_For_deserlize object= body.as(Test_Object_Class_For_deserlize.class);
	    
	    
	    Assert.assertEquals(object.name, "amit", "Name is not matched");
	    Assert.assertEquals(object.job, "Manager", "job  is not  matched");
	    
	    System.out.println("done...");
	}
	
}
