package RestAssured_2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class VerifyResponsebody 
{

	
	@Test
	public void verifyResponse()
	{
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://reqres.in/api/users?page=2").get();
		
		
	//	String body1=   resp.getBody().asString();
       
        
      //  System.out.println(body1);
      //  System.out.println(body);
       
		// Assert.assertEquals(body1.contains("George"), true, "name not matched");
        
        //data[4].first_name
        
         ResponseBody body1=    resp.getBody();
         JsonPath json =   body1.jsonPath();
         String fname=	json.get("data[4].first_name");
         Assert.assertEquals(fname, "Charles",  "name not matched");
         System.out.println("done");
	}
}

