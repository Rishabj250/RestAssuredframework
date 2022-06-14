package apiVerifications;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wnameless.json.flattener.JsonFlattener;

import basics.PostResponse;
import basics.Root;

public class GenericMethods {
	
	
	
	
	 public PostResponse jsontomap(String body) {
			
			//System.out.println("\n========== Simple Flatten ========== \n" + flattenedJson);
			Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(body.toString());
			ObjectMapper obj = new ObjectMapper();
			PostResponse r =null;
			try {
				 r =obj.readValue(body, PostResponse.class); 
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("\n=====Flatten As Map=====\n" + flattenedJson);
				// We are using Java8 forEach loop
			/*
			 * flattenedJsonMap.forEach((k, v) -> System.out.println(k+v));
			 * System.out.println("******************************************************");
			 * System.out.println(flattenedJsonMap);
			 */
			return r;
		}
		
	 public Root jsontomaps(String body) {
			
			//System.out.println("\n========== Simple Flatten ========== \n" + flattenedJson);
			Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(body.toString());
			ObjectMapper obj = new ObjectMapper();
			Root r =null;
			try {
				 r =obj.readValue(body, Root.class); 
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("\n=====Flatten As Map=====\n" + flattenedJson);
				// We are using Java8 forEach loop
			/*
			 * flattenedJsonMap.forEach((k, v) -> System.out.println(k+v));
			 * System.out.println("******************************************************");
			 * System.out.println(flattenedJsonMap);
			 */
			return r;
		}

}
