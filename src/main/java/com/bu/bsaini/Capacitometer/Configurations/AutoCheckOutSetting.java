package com.bu.bsaini.Capacitometer.Configurations;

public class AutoCheckOutSetting extends Configuration{
	private static final long serialVersionUID = 1L;
	private int autoCheckOutTime;
	
	public AutoCheckOutSetting() { }
	
	public AutoCheckOutSetting(int autoCheckOutTime) {
		this.autoCheckOutTime = autoCheckOutTime;
	}

	public int getAutoCheckOutTime() {
		return autoCheckOutTime;
	}

	public void setAutoCheckOutTime(int autoCheckOutTime) {
		this.autoCheckOutTime = autoCheckOutTime;
	}
}
