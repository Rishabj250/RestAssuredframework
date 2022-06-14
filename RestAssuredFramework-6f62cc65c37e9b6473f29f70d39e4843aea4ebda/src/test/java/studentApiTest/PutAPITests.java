package studentApiTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.sun.xml.xsom.impl.Ref.ContentType;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import io.restassured.RestAssured;

public class PutAPITests {
	
	HeaderConfigs head = new HeaderConfigs();
	PostAPIBuilder builder = new PostAPIBuilder();
	
	
	
	String PutBody="{\r\n" + 
			"    \"name\": \"morpheus\",\r\n" + 
			"    \"job\": \"zion resident\"\r\n" + 
			"}";
			
			Response response = RestAssured.given().when().headers(head.defaultHeaders())
			.body(builder.postRequestBody("Rishabh", "QA")).when().put(APIPath.apiPath.REQ_PUT);
	
	
				

}
