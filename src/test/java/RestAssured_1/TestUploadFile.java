package RestAssured_1;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestUploadFile 
{

	
	@Test
	public void testUploadFIle()
	{
		
	
		
		File f1= new File("C:\\Users\\vilas\\OneDrive\\Desktop\\upload.txt");
		
		
		RequestSpecification rs= RestAssured.given();
		
		
		Response resp= rs.baseUri("https://httpbin.org/post").multiPart("file", f1).post();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 209, "status code is not matched");
		
		System.out.println("file uploaded success...");
		
	}
	
}
