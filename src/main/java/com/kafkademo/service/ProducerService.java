package com.kafkademo.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkademo.kafkaconfig.KafkaProducerConfig;

@Service
public abstract class ProducerService<T> implements MessageService<T> {

	KafkaTemplate<String, T> kafkaTemplate;
	
	public ProducerService(){
		this.kafkaTemplate = new KafkaProducerConfig<T>().buildKafkaTemplate();
	}
	
}
