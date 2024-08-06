package com.marlonnunes.localstack;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalstackApplication.class, args);
	}

	@Value("${my-secret-key}")
	String mySecretKey;
	@PostConstruct
	public void init(){
		System.out.println("My secret key is: " + mySecretKey);
	}

}
