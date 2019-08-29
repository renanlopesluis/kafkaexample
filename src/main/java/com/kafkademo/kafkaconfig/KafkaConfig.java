package com.kafkademo.kafkaconfig;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig<T> {
	
	protected final String HOST = "127.0.0.1:9092";
	public final static String USER_TOPIC = "user_kafka";

	
}
