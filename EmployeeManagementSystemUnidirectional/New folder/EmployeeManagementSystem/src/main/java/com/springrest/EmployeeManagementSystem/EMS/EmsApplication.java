package com.springrest.EmployeeManagementSystem.EMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
		log.info("Going into the main method");

	}

}
