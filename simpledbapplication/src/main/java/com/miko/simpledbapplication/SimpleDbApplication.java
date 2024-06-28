package com.miko.simpledbapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SimpleDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDbApplication.class, args);
	}

}
