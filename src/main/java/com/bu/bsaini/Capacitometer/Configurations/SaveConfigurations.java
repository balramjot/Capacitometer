package com.bu.bsaini.Capacitometer.Configurations;

import org.json.simple.JSONArray;

public class SaveConfigurations {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String filePath = "src/main/resources/configuration_files/config1.json";
		ReadJsonFile readJsonFile = new ReadJsonFile();
		JSONArray gymJsonArray = readJsonFile.readInputJsonFile(filePath);
		WriteConfigurations wc = new WriteConfigurations(filePath);
		wc.parseJsonObject(gymJsonArray);
	}

}
