package com.kafkademo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkademo.model.User;

@Service
public class UserConsumerService implements MessageService<User>{
	
	private static final String KAFKA_LISTENER_CONTAINER = "kafkaListenerContainerFactory";
	private static final String GROUP_ID = "group_id";
	private static final String TOPIC = "user_kafka";

	@Override
	@KafkaListener(topics=TOPIC, groupId = GROUP_ID, containerFactory = KAFKA_LISTENER_CONTAINER)
	public void process(User user) {
		System.out.println("Consumed JSON message: "+user);	
	}	
}
