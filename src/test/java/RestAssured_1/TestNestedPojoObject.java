package RestAssured_1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestNestedPojoObject 
{

	
	@Test
	public void NestedPojoObject() throws JsonProcessingException
	{
		
		Pojo_01 p1=new Pojo_01();
		p1.setFirstname("amit giri");
		p1.setLastname("giri");;
		p1.setAge(30);
		p1.setGender("male");;
		p1.setSalary(30000);
		
		
		Pojo_02 p2= new Pojo_02();
		p2.setStreet("canal road");;
		p2.setCity("pune");
		p2.setState("mp");
		p2.setPincode(324567);;
		
		
		p1.setAddress(p2);;
		
		ObjectMapper mapper= new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p1);
		
		Response resp= RestAssured.given().contentType(ContentType.JSON).body(json).post("https://httpbin.org/post");
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),  200, "status code not matched");
		
		System.out.println("done...");
	}
	
}
