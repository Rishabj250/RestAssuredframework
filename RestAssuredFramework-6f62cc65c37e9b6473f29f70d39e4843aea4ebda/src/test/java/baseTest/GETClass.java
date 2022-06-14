package baseTest;

import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETClass {
	
	HeaderConfigs head = new HeaderConfigs();
	
	
	
	Response response = RestAssured.given().when().get(APIPath.apiPath.CREATE_POSTS);
	
	//if we want to pass the headers: we can pass like this as well just creating it.
	
	//Response responses = RestAssured.given().headers(head.defaultHeaders()).when().get(APIPath.apiPath.CREATE_POSTS);

	

}