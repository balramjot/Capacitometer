package com.bu.bsaini.Capacitometer.Configurations;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class ReadJsonFile {
	public static JSONArray readInputJsonFile(String path) {
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = new JSONArray();
	    try (FileReader fileReader = new FileReader(path)) {
	       Object object = jsonParser.parse(fileReader);    
	       jsonArray = (JSONArray) object;
	    } catch(Exception e) {
	       e.printStackTrace();
	    }
	    return jsonArray;
	}
}
