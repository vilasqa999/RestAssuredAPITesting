package RestAssured_1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_Patch_Method
{

	@Test
	public void testPatch()
	{
		

		  JSONObject json=new JSONObject();
		   
		   json.put("name","Amar");
		   json.put("job",  "Devloper");
		   
		   
		   RestAssured.baseURI= "https://reqres.in/api/users/696";
		   
		   RestAssured.given().header("content-type", "application/json").
		   contentType(ContentType.JSON).body(json.toJSONString()).
		   when().patch().
		   then().statusCode(200).log().all();
		   

		
	}

}
