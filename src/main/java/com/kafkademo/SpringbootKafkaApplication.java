package com.kafkademo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class SpringbootKafkaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaApplication.class, args);
	}

}
