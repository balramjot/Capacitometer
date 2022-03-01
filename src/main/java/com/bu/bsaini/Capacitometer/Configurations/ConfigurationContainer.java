package com.bu.bsaini.Capacitometer.Configurations;

public class ConfigurationContainer<T extends Configuration> {
	private T configuration;
	
	public ConfigurationContainer(T configuration) {
		this.configuration = configuration;
	}

	public T getConfiguration() {
		return configuration;
	}

	public void setConfiguration(T configuration) {
		this.configuration = configuration;
	}
}
