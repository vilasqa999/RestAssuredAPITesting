package POJO_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestUsePojo_1
{
	
	@Test
	public void testPojoClass1() throws JsonProcessingException
	{
		
		Employee_Address_Pojo address1 =new Employee_Address_Pojo();
		
		address1.setStreet("canal road");
		address1.setCity("pune");
		address1.setState("MP");
		address1.setPincode(411052);
		
		
		Employee_Pojo_1 emp1= new Employee_Pojo_1();
		emp1.setFirstname("Rahul");
		emp1.setLastname("giri");;
		emp1.setGender("male");
		emp1.setAge(35);
		emp1.setSalary(45000);
		emp1.setAddress(address1);
		
		
		ObjectMapper mapper =new ObjectMapper();
		String empjson= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		
		Response resp= RestAssured.given().baseUri("https://httpbin.org/post").contentType(ContentType.JSON).body(empjson).post();
	
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),200, "status code not matched");
		
		System.out.println("done...");
	}

}
