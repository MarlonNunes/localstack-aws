package com.marlonnunes.localstack;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LocalstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalstackApplication.class, args);
	}

	@Value("${aws.secret-key}")
	String mySecretKey;
	@PostConstruct
	public void init(){
		log.info("My secret key is: " + mySecretKey);
	}

}
