package RestAssured_1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test_serialize_deserlize
{
	
	@Test
	public void testSerielisAnddeserilise() throws JsonProcessingException
	{
		
		
		Test_POJO_Class p1=new Test_POJO_Class();
		
		p1.setFirstname("Amit");;
		p1.setLastname("Patil");
		p1.setAge(32);
		p1.setGender("Male");
		p1.setSalary(20000);
		
		
		ObjectMapper mapper=new ObjectMapper();
		
       String json=	mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p1);
       
       System.out.println(json);
       
       Response resp= RestAssured.given().contentType(ContentType.JSON).body(json).post("https://httpbin.org/post");
       
       resp.prettyPrint();
       Assert.assertEquals(resp.statusCode(),200, "status code not matching");
       System.out.println("done serlization....");
       
       System.out.println("==================================================================");
       
       Test_POJO_Class p2= mapper.readValue(json,  Test_POJO_Class.class);
       
       System.out.println("First name:" + p2.getFirstname() );
       System.out.println("Last name: " + p2.getLastname());
       System.out.println("Enter age:" + p2.getAge());
       System.out.println("Enter gender:" + p2.getGender());
       System.out.println("Get salary: "+ p2.getSalary());
       
       System.out.println("done with deserlization...");
	}
	

}
