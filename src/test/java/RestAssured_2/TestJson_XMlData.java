package RestAssured_2;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
//import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestJson_XMlData 
{
	
	@Test	
	public void testJsonXMlResp()
	{
	
		String xmldata="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		
		
		String jsondata= "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		
		RequestSpecification rs= RestAssured.given();
		
		Response resp= rs.baseUri("https://petstore.swagger.io/v2/pet").headers("accept","application/xml").headers("Content-Type","application/xml")
		.body(xmldata).post();
		
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(),200,"status code not matched");
		
		//Approch #1 
		//resp.then().body("Pet.name", Matchers.equalTo("doggie"));
		
		
		//Approch #2
    	XmlPath path1= new XmlPath(resp.asString());
		String name=path1.get("Pet.name").toString();
		
		Assert.assertEquals(name,  "doggie", "name not matched");
		System.out.println("done");
	}

}
