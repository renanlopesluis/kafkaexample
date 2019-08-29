package com.kafkademo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kafkademo.kafkaconfig.KafkaConfig;
import com.kafkademo.model.User;

import lombok.AllArgsConstructor;

@Service
@Qualifier("userProducerService")
@AllArgsConstructor
public class UserProducerService extends ProducerService<User>{
		
	@Override
	public void process(User user) {
		System.out.println("Producing Object "+user+" to message.");
		kafkaTemplate.send(KafkaConfig.USER_TOPIC, user);
	}

}
