package com.kafkademo.service;

import org.springframework.stereotype.Service;

@Service
public interface KafkaService <T>{
	
	void process(T object);

}
