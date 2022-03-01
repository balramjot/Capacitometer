package com.bu.bsaini.Capacitometer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bu.bsaini.Capacitometer.Configurations.LoadConfigurations;

@SpringBootApplication
public class CapacitometerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CapacitometerApplication.class, args);
		
		Thread databaseConnectionThread = new Thread(new InitDatabaseConnection());
		Thread gymMemberLoaderThread = new Thread(new InitGymMembersLoader());
		Thread gymMaxCapacityLoaderThread = new Thread(new InitGymMaxCapacityLoader());
		Thread automaticCheckOutThread = new Thread(new InitAutomaticCheckOut());
		Thread readConfigurationsThread = new Thread(new LoadConfigurations());
		
		databaseConnectionThread.start();
		databaseConnectionThread.join();
		gymMemberLoaderThread.start();
		gymMemberLoaderThread.join();
		gymMaxCapacityLoaderThread.start();
		gymMaxCapacityLoaderThread.join();
		automaticCheckOutThread.start();
		automaticCheckOutThread.join();
		readConfigurationsThread.start();
	}

}
