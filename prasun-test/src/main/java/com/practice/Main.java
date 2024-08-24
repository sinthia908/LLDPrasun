package com.practice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		try {
		Object obj= (JSONArray) parser.parse(new FileReader("C:\\project\\project-sample-json"));
        JSONObject jsonObject =  (JSONObject) obj;
        String name = (String) jsonObject.get("first_name");
        System.out.println(name);
        
        
		}catch(Exception ex) {
			
		}
	}

}
