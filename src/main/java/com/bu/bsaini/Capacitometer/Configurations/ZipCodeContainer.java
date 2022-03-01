package com.bu.bsaini.Capacitometer.Configurations;

public class ZipCodeContainer<T> {
	private T dataType;
	
	public ZipCodeContainer() { }
	
	public ZipCodeContainer(T dataType) {
		this.dataType = dataType;
	}

	public T getDataType() {
		return dataType;
	}

	public void setDataType(T dataType) {
		this.dataType = dataType;
	}
	
	public T getValue() {
		String newd;
		if(dataType.toString() != null) {
			 newd = "a";
		} else {
			newd = "b";
		}
		return (T) newd;
	}
}
