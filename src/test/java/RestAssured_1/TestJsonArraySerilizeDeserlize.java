package RestAssured_1;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestJsonArraySerilizeDeserlize 
{

	@Test
	public void testJsonArray() throws JsonProcessingException
	{
		
		

		Test_POJO_Class p1=new Test_POJO_Class();
		
		p1.setFirstname("Amit");;
		p1.setLastname("Patil");
		p1.setAge(32);
		p1.setGender("Male");
		p1.setSalary(20000);
		
		
        Test_POJO_Class p2=new Test_POJO_Class();
		
		p2.setFirstname("Balu");;
		p2.setLastname("Giri");
		p2.setAge(30);
		p2.setGender("Male");
		p2.setSalary(30000);
		
		
		

        Test_POJO_Class p3=new Test_POJO_Class();
		
		p3.setFirstname("Anil");;
		p3.setLastname("Giri");
		p3.setAge(39);
		p3.setGender("Male");
		p3.setSalary(93000);
		
		List<Test_POJO_Class> list= new ArrayList<>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		
		ObjectMapper mapper=new ObjectMapper();
		
       String json=	mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
       
       System.out.println(json);
       
       Response resp= RestAssured.given().contentType(ContentType.JSON).body(json).post("https://httpbin.org/post");
       
       resp.prettyPrint();
       Assert.assertEquals(resp.statusCode(),200, "status code not matching");
       System.out.println("done serlization....");
       
       System.out.println("==================================================================");
       
      /*
       
       Test_POJO_Class p10= mapper.readValue(json,  Test_POJO_Class.class);
       
       System.out.println("First name:" + p2.getFirstname() );
       System.out.println("Last name: " + p2.getLastname());
       System.out.println("Enter age:" + p2.getAge());
       System.out.println("Enter gender:" + p2.getGender());
       System.out.println("Get salary: "+ p2.getSalary());
 
		*/
	}
	
}
