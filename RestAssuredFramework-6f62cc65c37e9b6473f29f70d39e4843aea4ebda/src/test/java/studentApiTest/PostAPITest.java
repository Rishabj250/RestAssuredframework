package studentApiTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import apiVerifications.GenericMethods;
import baseTest.BaseTest;
import basics.Root;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostAPITest extends BaseTest {

	String id;

	HeaderConfigs header = new HeaderConfigs();
	PostAPIBuilder builder = new PostAPIBuilder();
	APIVerification verify = new APIVerification();
	GenericMethods generic = new GenericMethods();

	
	
	
	@Test(priority = 1, description = "Validating the Post Request")
	public void validPostAPITest() {

		test.log(LogStatus.INFO, "My test is starting.....");

		// getting the response
		Response response = RestAssured.given().when().headers(header.defaultHeaders())
				.body(builder.postRequestBody("Rishabh", "QA")).when().post(APIPath.apiPath.CREATE_POSTS);

		System.out.println(response.asString());

		
		// converting the actual json into map
		Root actualJson = generic.jsontomaps(response.asString());

		boolean flag = verify.PostApiVerification(actualJson);
		System.out.println(flag);

		if (flag == true) {
			System.out.println("Test Case Succesfully Run");
		} else {
			System.out.println("Test Case Failed");
		}

		
		test.log(LogStatus.INFO, "My test has been ended.....");

	}

}
