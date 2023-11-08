package POJO_Classes;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestEmployee_Pojo_02 
{

	@Test
	public void testPojoClass() throws JsonProcessingException
	{
		
		
		EmployeePojo_02 emp1= new EmployeePojo_02();
		
		emp1.setFirstname("amit");;
		emp1.setLastname("giri");
		//emp1.setAge(30);
		emp1.setGender("male");
		emp1.setSalary(23000);
		emp1.setCity("pune");
		
		
		ObjectMapper mapper=new ObjectMapper();
		String empjson= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		System.out.println(empjson);
		
		
	}
}
