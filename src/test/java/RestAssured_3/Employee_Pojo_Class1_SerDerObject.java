package RestAssured_3;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee_Pojo_Class1_SerDerObject 
{
	@Test
	public void testPojoClass() throws JsonProcessingException
	{
	Employee_Pojo_Class1 emp1 =new Employee_Pojo_Class1();
	
	emp1.setFirstName("Amit");;
	emp1.setLastname("giri");;
	emp1.setCity("pune");
	emp1.setAge(30);
	emp1.setSalary(10000);
	
	
	ObjectMapper mapper= new ObjectMapper();
	String empjson= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
	System.out.println(empjson);
	
	//reverse
	
	Employee_Pojo_Class1 emp2= mapper.readValue(empjson,Employee_Pojo_Class1.class);
	
	System.out.println(emp2.getFirstname());
	System.out.println(emp2.getLastname());
	System.out.println(emp2.getSalary());
	System.out.println(emp2.getAge());
	System.out.println(emp2.getCity());
	
	
	}
}
