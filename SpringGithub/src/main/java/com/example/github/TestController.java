package com.example.github;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/payload")
	public ResponseEntity<String> Payload() {
		
		
		String message;
		JSONObject json = new JSONObject();
		json.put("referenceID", "1234");
		json.put("businessName", "Test");

		JSONArray array = new JSONArray();
		JSONObject item = new JSONObject();
		item.put("paramId", "1");
		item.put("EMail", "email@gmail.com");
		item.put("Conref", "first");
		item.put("Value", "A");
	    array.add(item);
	    item = new JSONObject();
		item.put("paramId", "2");
		item.put("EMail", "email2@gmail.com");
		item.put("Conref", "second");
		item.put("Value", "B");
		
        array.add(item);
		json.put("ParamList", array); 
		message = json.toString();

        JSONArray paramlist = (JSONArray)json.get("ParamList");
        Iterator iterator = paramlist.iterator();

	    String content = 
	           "<header>"
	         + "</header>" + "Welcome "+json.get("businessName")+"<br>"
	         +"<table><tr><th> Code Reference </th><th> Code Vale </th><tr>";
	         while(iterator.hasNext())
	         {
	        	 JSONObject param = (JSONObject) iterator.next();
	        	 content +="<tr><th>"+param.get("Conref")+"</th><th>"+param.get("Value")+"</th>";
	         }
	        
	         content += "</table>";
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.setContentType(MediaType.TEXT_HTML);

	    return new ResponseEntity<String>(content, responseHeaders, HttpStatus.NOT_FOUND);
	}
}
