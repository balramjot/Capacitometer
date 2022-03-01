package com.bu.bsaini.Capacitometer.Configurations;

import com.bu.bsaini.Capacitometer.Controllers.FuncControllers.ReadObjectStream;

public class LoadConfigurations implements Runnable {
	public static Configuration configuration = new Configuration();
	@Override
	public void run() {
		configuration = ReadObjectStream.readInputDatFile("src/main/resources/configuration_files/config1.dat");
		/**
		 * can use :
		 * config1.dat
		 * config2.dat
		 * config3.dat
		 * config4.dat
		 * config5.dat
		 */
		
	}

}
