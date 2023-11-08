package POJO_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestSerlize_Deserlize 
{

	@Test
	public void serlizeDerlise() throws JsonProcessingException
	{
		
		
	TestEmployeeData emp1= new TestEmployeeData();
	
	emp1.setFirstname("Rahul");
	emp1.setLastname("varma");
	emp1.setAge(29);
	emp1.setSalary(31000);
	
	
	ObjectMapper mapper= new ObjectMapper();
	
	String jsondata= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
	
	Response resp= RestAssured.given().baseUri("https://httpbin.org/post").contentType(ContentType.JSON).body(jsondata).post();
	
	resp.prettyPrint();
	
	Assert.assertEquals(resp.statusCode(),200, "status code not matched");
	System.out.println("done with post");
	
	System.out.println("reverse operation:--------------------------");
	
	
	TestEmployeeData emp2= mapper.readValue(jsondata, TestEmployeeData.class);
	
	System.out.println("First name: "+ emp2.getFirstname());
	System.out.println("Last name: "+ emp2.getLastname());
	System.out.println("Age: "+ emp2.getAge());
	System.out.println("Salary: "+ emp2.getSalary());
	
	
	System.out.println("done all.................");
	}
	
}
