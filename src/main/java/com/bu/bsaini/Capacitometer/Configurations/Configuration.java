package com.bu.bsaini.Capacitometer.Configurations;

import java.io.Serializable;

import org.json.simple.JSONObject;

public class Configuration implements Serializable {
	private static final long serialVersionUID = 1L;
	private UISettings uiSettings;
	private AutoCheckOutSetting autoCheckOutSetting;
	private ContactInformation contactInformation;
	
	public Configuration() { }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public UISettings getUiSettings() {
		return uiSettings;
	}

	public void setUiSettings(UISettings uiSettings) {
		this.uiSettings = uiSettings;
	}	
	
	public AutoCheckOutSetting getAutoCheckOutSetting() {
		return autoCheckOutSetting;
	}

	public void setAutoCheckOutSetting(AutoCheckOutSetting autoCheckOutSetting) {
		this.autoCheckOutSetting = autoCheckOutSetting;
	}

	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getStringFromJsonObject(JSONObject jsonObject, String fieldValue) {
		return (String) jsonObject.get(fieldValue);
	}
	
	public Integer getIntegerFromJsonObject(JSONObject jsonObject, String fieldValue) {
		return Integer.parseInt(jsonObject.get(fieldValue).toString());
	}
}
