package RestAssured_2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestQueryParam 
{

	@Test
	public void testqueryparam()
	{
		
		RequestSpecification  rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://reqres.in/api/users").queryParam("page","2").queryParam("id", "2").get();
		
       JsonPath path=	resp.jsonPath();
       String name=      path.get("data.first_name");
       Assert.assertEquals(name,  "Janet", "name not matched");
       System.out.println("done ...");
	}
	
}
