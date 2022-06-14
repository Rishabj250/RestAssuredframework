package studentApiTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import apiVerifications.GenericMethods;
import baseTest.BaseTest;
import basics.PostResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPITests extends BaseTest {

	APIVerification verify = new APIVerification();
	GenericMethods generic = new GenericMethods();

	
	//GET request : Automation
	//Before running pass the argument -->Vaargument as -Denv=qa
	@Test
	public void getAPITest() {

		test.log(LogStatus.INFO, "My test is starting......");

		//As for now creating here but we can fetch it from GETClass
		Response response = RestAssured.given().when().get(APIPath.apiPath.CREATE_POSTS);

		System.out.println(response.asString());
		PostResponse actualJson = generic.jsontomap(response.asString());
		boolean flag = verify.CommonVerifications(actualJson);
		System.out.println(flag);

		if (flag == true) {
			System.out.println("Test Case Succesfully Run");
		} else {
			System.out.println("Test Case Failed");
		}

		test.log(LogStatus.INFO, "My test is ended......");

	}
	

	
}
