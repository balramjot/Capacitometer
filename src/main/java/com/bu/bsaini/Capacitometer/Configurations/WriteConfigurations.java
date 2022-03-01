package com.bu.bsaini.Capacitometer.Configurations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.WriteObjectStream;

public class WriteConfigurations extends ParseJsonObjectFactory implements FileName{
	
	private String path;
	
	public WriteConfigurations(String path) {
		this.path = path;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void parseJsonObject(JSONArray arr) {
		arr.forEach(g -> {
			JSONObject obj = (JSONObject) g;
			JSONObject jsonObject = (JSONObject) obj.get("Configuration");
			JSONObject childJsonObject = (JSONObject) jsonObject.get("ContactInformation");
			UISettings uiSettings = new UISettings();
			uiSettings.setTitle(uiSettings.getStringFromJsonObject(jsonObject, "title"));
			uiSettings.setLogo(uiSettings.getStringFromJsonObject(jsonObject, "logo"));
			uiSettings.setTheme(uiSettings.getStringFromJsonObject(jsonObject, "theme"));
			uiSettings.setCopyright(uiSettings.getStringFromJsonObject(jsonObject, "copyright"));
			
			AutoCheckOutSetting autoCheckOutSetting = new AutoCheckOutSetting();
			autoCheckOutSetting.setAutoCheckOutTime(autoCheckOutSetting.getIntegerFromJsonObject(jsonObject, "autocheckouttime"));
			
			ContactInformation contactInformation = new ContactInformation();
			contactInformation.setAddress(contactInformation.getStringFromJsonObject(childJsonObject, "address"));
			contactInformation.setCity(contactInformation.getStringFromJsonObject(childJsonObject, "city"));
			contactInformation.setState(contactInformation.getStringFromJsonObject(childJsonObject, "state"));
			contactInformation.setZipcode(contactInformation.getIntegerFromJsonObject(childJsonObject, "zipcode"));
			
			Configuration configuration = new Configuration();
			configuration.setUiSettings(uiSettings);
			configuration.setAutoCheckOutSetting(autoCheckOutSetting);
			configuration.setContactInformation(contactInformation);

			WriteObjectStream.writeOutputDatFile(getFileName(), configuration);
		});
		System.out.println("Config added successfully !!!");
	}
	
	@Override
	public String getFileName() {
		String fileName = path.replace("json","dat");
		return fileName;
	}

}
