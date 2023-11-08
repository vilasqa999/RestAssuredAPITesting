package RestAssured_2;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UploadFile_Image 
{
	
	@Test(enabled=false)	
	public void uploadFile()
	{
		
		
		File f1=new File("C:\\Users\\vilas\\OneDrive\\Desktop\\upload.txt");
		File f2=new File("C:\\Users\\vilas\\OneDrive\\Desktop\\upload1.txt");
		
		Response resp= RestAssured.given().baseUri("https://httpbin.org/post").multiPart("file", f1).multiPart("file",f2).post();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),200 , "status code is not matching");
		
		System.out.println("done...");
		
   }

	
	
	@Test	
	public void uploadImage()
	{
		
		
		File f1=new File("C:\\Users\\vilas\\OneDrive\\Pictures\\Screenshots\\error.png");
		//File f2=new File("C:\\Users\\vilas\\OneDrive\\Desktop\\upload1.txt");
		
		Response resp= RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet/1234/uploadImage").multiPart("file", f1).contentType("multipart/form-data").post();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),200 , "status code is not matching");
		
		System.out.println("done with upload image...");
		
   }

	
}
