package com.example.CDEK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CdekApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdekApplication.class, args);
	}

}

