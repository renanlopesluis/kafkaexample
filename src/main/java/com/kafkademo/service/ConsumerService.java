package com.kafkademo.service;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

import com.kafkademo.kafkaconfig.KafkaConsumerConfig;

public abstract class ConsumerService<T> implements MessageService<T>{
	
	ConcurrentKafkaListenerContainerFactory<String,T> kafkaListenerContainer;
	
	public ConsumerService() {
		kafkaListenerContainer = new KafkaConsumerConfig<T>().concurrentKafkaListenerContainer();		
	}
	
}
