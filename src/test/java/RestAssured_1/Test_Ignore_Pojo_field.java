package RestAssured_1;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test_Ignore_Pojo_field 
{

	@Test
	public void testIgnorefield() throws JsonProcessingException 
	{
		
		Emp_Pojo_Class p1 =new Emp_Pojo_Class();
		
		//Emp_Pojo_01 p1= new Emp_Pojo_01();
		p1.setFirstname("Amit");
		p1.setLastname("Giri");
		p1.setAge(32);
		p1.setFullname("Amit Giri");
		p1.setSalary(43000);
		p1.setIsmarreid("No");
		
		
	
		
		
		ObjectMapper mapper= new ObjectMapper();
		
		String json= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p1);
		System.out.println(json);
		
		
				
		
	}
	
}
