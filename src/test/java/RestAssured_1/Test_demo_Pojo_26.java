package RestAssured_1;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test_demo_Pojo_26 
{
	@Test
	
	public void testDemo() throws JsonMappingException, JsonProcessingException
	{
		
		
		String jsondata= "{\r\n"
				+ "   \"lastname\":\"Amod\",\r\n"
				+ "   \"lastName\":\"Mahajan\",\r\n"
				+ "   \"age\": 28,\r\n"
				+ "   \"salary\": 10000.56,\r\n"
				+ "   \"gender\":\"male\"\r\n"
				+ "}\r\n"
				+ "";
		
		
		ObjectMapper mapper=new ObjectMapper();
		
		Employee_26 p1= mapper.readValue(jsondata, Employee_26.class);
		
		System.out.println("==============json object tp class object");
		
		System.out.println("first name:" + p1.getFirstname());
	//	System.out.println("firstname:"  + p1.get);
		System.out.print("Lastname:" + p1.getLastname());
		System.out.println("age: " + p1.getAge());
		System.out.println("salary: " + p1.getSalary());
		System.out.println("gender :" + p1.getGender());
		
		
		
		
		
		
	}

}
