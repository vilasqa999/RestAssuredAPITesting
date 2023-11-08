package RestAssured_1;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJsonInclude 
{
	
	@Test	
	public void method1() throws JsonProcessingException
	{
	
		Emp_Pojo_01 p1= new Emp_Pojo_01();
		p1.setFirstname("Amit");
		p1.setLastname("Giri");
		p1.setGender("male");
		p1.setIsMarried("yes");
		p1.setSalry(40000);
		p1.setAge(40);
		
		
		ObjectMapper mapper= new ObjectMapper();
		
		String json= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p1);
		System.out.println(json);
		
		String json1= "{\r\n"
				+ "  \"firstname\" : \"Amit\",\r\n"
				+ "  \"lastname\" : \"Giri\",\r\n"
				+ "  \"age\" : 32,\r\n"
				+ "  \"ismarreid\" : \"No\",\r\n"
				+ "  \"salary\" : 43000.0\r\n"
				+ "}";
		
		
		Emp_Pojo_Class p3= mapper.readValue(json1, Emp_Pojo_Class.class);
		System.out.println("reverse operation  .....................");
		
		System.out.println("First name:" + p3.getFirstname());
		System.out.println("Last name: " + p3.getLastname());
		System.out.println("Age:" + p3.getAge());
		System.out.println("is married: " + p3.getIsmarreid());
		System.out.println("salary:" + p3.getSalary());
		System.out.println("fullname:" + p3.getFullname());
		
		
	}

}
