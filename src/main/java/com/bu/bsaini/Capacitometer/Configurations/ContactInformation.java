package com.bu.bsaini.Capacitometer.Configurations;

public class ContactInformation extends Configuration {
	private static final long serialVersionUID = 1L;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	
	public ContactInformation() { }
	
	public ContactInformation(String address, String city, String state, int zipcode) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
