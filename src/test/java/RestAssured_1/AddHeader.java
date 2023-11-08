package RestAssured_1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeader 
{

	@Test
	public void checkAddHeader()
	{
		
		Map<String, String> map= new HashMap<>();
		
		map.put("Header1", "value1");
		map.put("header2", "value2"); 
		
		
		
		RequestSpecification rs= RestAssured.given();
		
		System.out.println(rs.headers(map));
		//rs.header("Header1", "Value");
		
		Response resp= rs.get("https://reqres.in/api/users?page=1");
		
		System.out.println(resp.asString());
		
		System.out.println("successs");
	}
	
}
