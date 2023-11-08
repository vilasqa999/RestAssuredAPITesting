package RestAssured_1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_Get_Method 
{

	@Test
	public void getMethod()
	{
	Response resp= get("https://reqres.in/api/users?page=2");
	
	System.out.println(resp.getBody().asString());
	System.out.println(resp.getStatusCode());
	System.out.println(resp.getTime());
	System.out.println(resp.getHeader("content-type"));
	
	int expectstatuscode=200;
	
	int expectstatuscode1= resp.getStatusCode();
	
	Assert.assertEquals(expectstatuscode, expectstatuscode1);
	
	}
	@Test
	
	public void test02()
	{
	
		
		baseURI="https://reqres.in/api/users";
		given().queryParam("page", "2")
		.when().get().then().statusCode(200);
	}
	
}
