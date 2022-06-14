package apiBuilders;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;


public class PostAPIBuilder {
	
	
	
	//using the map for the body
	public Map<String, String> postRequestBody(String name, String job){
		Map<String, String> body = new HashMap<String, String>();
		body.put("Rishabh" , name);
		body.put("QA", job);
		
		return body;
	}
	
	
	
	
}
