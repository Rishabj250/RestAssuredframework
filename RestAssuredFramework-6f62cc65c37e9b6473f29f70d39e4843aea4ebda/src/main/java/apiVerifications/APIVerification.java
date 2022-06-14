package apiVerifications;

import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;
import com.github.wnameless.json.flattener.JsonFlattener;

import basics.PostResponse;
import basics.Root;
import io.restassured.response.Response;
import utils.ExtentReportListner;

public class APIVerification extends ExtentReportListner {
	
	GenericMethods generic = new GenericMethods();
	

	public static void responseCodeValiddation(Response response, int statusCode) {

		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(LogStatus.PASS,
					"Successfully validdated status code, status code is :: " + response.getStatusCode());
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL,
					"Expected status code is :: " + statusCode + " , insted of getting :: " + response.getStatusCode());
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	
	
	public static void responseTimeValidation(Response response) {
		try {
			long time = response.time();
			test.log(LogStatus.INFO, "Api response time is :: " + time);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	//This method is created to verify the get request
	public boolean CommonVerifications(PostResponse actualJson)
	{
		
		PostResponse expected_json = getUser();
		System.out.println(expected_json.toString());
		boolean result = false;
		 if (expected_json.equals(actualJson)) {
			 result =true;
			 System.out.println("Pass");
			 
		}
		return result;
	}

	//Creating the api verification for post request
	public boolean PostApiVerification(Root actualJson)
	{
		
		Root expected_json= getExpectedJson();
		boolean result = false;
		 if (expected_json.equals(actualJson)) {
			 result=true;
			 System.out.println("Pass");
			 
		}
		return result;
	}

	
	//getting the excepted json  for GET request
	public PostResponse getUser() {

		PostResponse r = null;

		System.out.println("Expceted json");
		String expected_json = "{\"page\":1,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":1,\"email\":\"george.bluth@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Bluth\",\"avatar\":\"https://reqres.in/img/faces/1-image.jpg\"},{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},{\"id\":3,\"email\":\"emma.wong@reqres.in\",\"first_name\":\"Emma\",\"last_name\":\"Wong\",\"avatar\":\"https://reqres.in/img/faces/3-image.jpg\"},{\"id\":4,\"email\":\"eve.holt@reqres.in\",\"first_name\":\"Eve\",\"last_name\":\"Holt\",\"avatar\":\"https://reqres.in/img/faces/4-image.jpg\"},{\"id\":5,\"email\":\"charles.morris@reqres.in\",\"first_name\":\"Charles\",\"last_name\":\"Morris\",\"avatar\":\"https://reqres.in/img/faces/5-image.jpg\"},{\"id\":6,\"email\":\"tracey.ramos@reqres.in\",\"first_name\":\"Tracey\",\"last_name\":\"Ramos\",\"avatar\":\"https://reqres.in/img/faces/6-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
		//converting excepted json into map
		r = generic.jsontomap(expected_json);

		return r;
	}
	
	//Getting excepted json for POST request 
	public Root getExpectedJson() {

		Root r = null;

		System.out.println("Expceted json");
		String expected_json = "{\"name\":\"Rishabh\",\"job\":\"QA\"}";
		r = generic.jsontomaps(expected_json);

		return r;
	}
	
	
}