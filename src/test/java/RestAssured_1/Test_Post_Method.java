package RestAssured_1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_Post_Method 
{

	   @Test
	   public void testpost01()
	  {
		 
		   JSONObject json=new JSONObject();
		   
		   json.put("name","amit");
		   json.put("job",  "QA");
		   
		   
		   RestAssured.baseURI= "https://reqres.in/api/users";
		   
		   RestAssured.given().header("content-type", "application/json")
		   .contentType(ContentType.JSON).body(json.toJSONString()).when().post().then().statusCode(201).log().all();
		   
	  }
	
}
