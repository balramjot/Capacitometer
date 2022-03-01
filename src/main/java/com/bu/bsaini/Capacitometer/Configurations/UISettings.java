package com.bu.bsaini.Capacitometer.Configurations;

public class UISettings extends Configuration{
	private static final long serialVersionUID = 1L;
	private String title;
	private String logo;
	private String theme;
	private String copyright;
	
	public UISettings() { }
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public UISettings(String title, String logo, String theme, String copyright) {
		super();
		this.title = title;
		this.logo = logo;
		this.theme = theme;
		this.copyright = copyright;
	}
	
}
