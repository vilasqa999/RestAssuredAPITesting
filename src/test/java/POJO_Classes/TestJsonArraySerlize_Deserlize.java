package POJO_Classes;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestJsonArraySerlize_Deserlize 
{
	@Test
	public void testJsonArrayObjecttoJson() throws JsonProcessingException
	{
		
		
		TestEmployeeData emp1=new TestEmployeeData();
		emp1.setFirstname("amit");
		emp1.setLastname("giri");
		emp1.setAge(20);;
		emp1.setSalary(20000);
		
		
		TestEmployeeData emp2=new TestEmployeeData();
		emp2.setFirstname("balu");
		emp2.setLastname("giri");
		emp2.setAge(23);;
		emp2.setSalary(20450);
		
		
		TestEmployeeData emp3=new TestEmployeeData();
		emp3.setFirstname("chandu");
		emp3.setLastname("giri");
		emp3.setAge(30);;
		emp3.setSalary(4500);
		
		
		TestEmployeeData emp4=new TestEmployeeData();
		emp4.setFirstname("dagadu");
		emp4.setLastname("giri");
		emp4.setAge(30);;
		emp4.setSalary(56000);
		
		
		List<TestEmployeeData> list=new ArrayList<>();
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		
		
		ObjectMapper mapper=new ObjectMapper();
		
		String jsondata= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
		
		Response resp= RestAssured.given().baseUri("https://httpbin.org/post").contentType(ContentType.JSON).body(jsondata).post();
		
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),200, "status code not matched");
		
		System.out.println("done half work");
		
		
		System.out.println("===============================================");
		ResponseBody body= resp.getBody();
		
		JsonPath path= body.jsonPath();
		
		List<TestEmployeeData>  emp101= path.getList("json", TestEmployeeData.class);
		
		for(TestEmployeeData list1:emp101)
		{
			System.out.println(list1.getFirstname() + " " + list1.getLastname());
			//System.out.println("Last name: "+ list1.getLastname());
		//	System.out.println("Age: "+ list1.getAge());
		//	System.out.println("Salary: "+ list1.getSalary());
			
		}
			
		
		System.out.println("all done .....");
	}

	
		
	
}
