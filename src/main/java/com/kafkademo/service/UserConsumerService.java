package com.kafkademo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userConsumerService")
public class UserConsumerService<User> extends ConsumerService<User>{
	
	private static final String KAFKA_LISTENER_CONTAINER = "concurrentKafkaListenerContainer";
	private static final String GROUP_ID = "group_id";
	private static final String TOPIC = "user_kafka";

	@KafkaListener(topics=TOPIC, groupId = GROUP_ID, containerFactory = KAFKA_LISTENER_CONTAINER)
	@Override
	public void process(User user) {
		System.out.println("Consumed JSON message: "+user);	
	}	
}
