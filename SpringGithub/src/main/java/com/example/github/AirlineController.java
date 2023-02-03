package com.example.github;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.github.model.Airline;
import com.example.github.model.Airlinepojo;
import com.example.github.model.ParamList;
import com.example.github.repository.AirlineRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AirlineController {
	
	@Autowired
	public AirlineRepo airlinerepo;
	
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
		String content="";
		try {
		
			 JSONParser parser = new JSONParser();
			 
			 File resource = new ClassPathResource("test-json.json").getFile();
				String text = new String(Files.readAllBytes(resource.toPath()));
			
				 json = (JSONObject) parser.parse(text);
				 System.out.println(json);
		/*	ObjectMapper mapper = new ObjectMapper();
			TypeReference<ParamList[]> typeReference = new TypeReference<ParamList[]>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/test1.json");
			try {
				ParamList[] users = mapper.readValue(inputStream,typeReference);
			//	userService.save(users);
				System.out.println("Users Saved!"+users);
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}*/
			
			
			
	
        JSONArray paramlist = (JSONArray)json.get("ParamList");
        Iterator iterator = paramlist.iterator();
        List<ParamList> plist = new ArrayList<ParamList>();
    

	     content = 
	           "<header>"
	         + "</header>" + "Welcome "+json.get("businessName")+"<br>"
	         +"<table><tr><th> Code Reference </th><th> Code Vale </th><tr>";
	         while(iterator.hasNext())
	    // for(int i=0;i<plist.size();i++)
	         {
	        	 JSONObject param = (JSONObject) iterator.next();
	        //	 ParamList list = (ParamList) plist.get(i);
	        	 content +="<tr><th>"+param.get("Conref")+"</th><th>"+param.get("Value")+"</th>";
	        	// content +="<tr><th>"+list.getConref()+"</th><th>"+list.getValue()+"</th>";
	       //  }
	         }
	        
	         content += "</table>";
	         
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.setContentType(MediaType.TEXT_HTML);

	    return new ResponseEntity<String>(content, responseHeaders, HttpStatus.NOT_FOUND);
	}

	
	
	@PostMapping("/airline")
	public Airline AddAirLine(@RequestBody Airline airline)
	{
		
		airlinerepo.save(airline);
	return airline;	
	
	
	}
	
	@PostMapping("/search")
	public List<Airline> SearchAirLine(@RequestBody String airline) throws ParseException
	{
		
		 JSONParser parser = new JSONParser();
		 JSONObject json = (JSONObject) parser.parse(airline);
		 String arrival = json.get("arrival").toString();
		 String departure = json.get("departure").toString();
		//airlinerepo.save(airline);
	return airlinerepo.searchFlight(arrival, departure);	
	
	
	}
	
	
	
	@GetMapping("/airline/{id}")
	public Airline AddAirLine(@PathVariable int id)
	{
		
	Optional<Airline> airline=	airlinerepo.findById(id);
	return airline.get();
	
	
	}
	
	 @GetMapping("/airlines")
	    public List<Airline> fetchAirlineList()
	    {
		// @SuppressWarnings("deprecation")
	//	Airline air = airlinerepo.getById(1);
	 //Airline air = new Airline("A234","Erode","Madurai","10:00 AM", "2:00 PM");
	 //airlinerepo.save(air);
		
		 System.out.println("test case"   );
		 List<Airline> airl=   airlinerepo.findAll();
		// Airline air = airl.get(0);
		 
		// System.out.println(air.toString() );

	        return  airl;
	    }
	
}
