package RestAssured_1;

public class Pojo_01
{

	private String firstname;

	private String lastname;
	private int age;
	private String gender;
	private double salary;
	
	public Pojo_02 getAddress() {
		return address;
	}
	public void setAddress(Pojo_02 address) {
		this.address = address;
	}
	private Pojo_02 address;
	
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
