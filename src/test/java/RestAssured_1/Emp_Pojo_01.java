package RestAssured_1;

import com.fasterxml.jackson.annotation.JsonInclude;

  //@JsonInclude(JsonInclude.Include.NON_DEFAULT.NON_NULL.NON_EMPTY)
public class Emp_Pojo_01 
{

	private String firstname;
	private String lastname;
	private String IsMarried;
	private int age;
	private double salry;
	private String gender;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getIsMarried() {
		return IsMarried;
	}
	public void setIsMarried(String isMarried) {
		IsMarried = isMarried;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalry() {
		return salry;
	}
	public void setSalry(double salry) {
		this.salry = salry;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
