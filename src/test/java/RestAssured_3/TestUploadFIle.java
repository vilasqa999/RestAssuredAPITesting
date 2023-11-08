package RestAssured_3;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestUploadFIle 
{

	@Test
	public void testUploadFile()
	{
		
		String file="C:\\Users\\vilas\\OneDrive\\Desktop\\upload.txt";
		String file1="C:\\Users\\vilas\\OneDrive\\Desktop\\upload1.txt";

		Response resp= RestAssured.given().baseUri("https://httpbin.org/post").multiPart("File", file).multiPart("File", file1).
				post();
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),200,"status code not matched");
		System.out.println("file upload done...");
	}
}

