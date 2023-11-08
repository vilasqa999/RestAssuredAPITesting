package RestAssured_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Employee_26 
{

	
	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private double salary;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstame(String firstame) {
		this.firstname = firstame;
	}
	
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	
}
