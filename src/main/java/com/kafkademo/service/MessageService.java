package com.kafkademo.service;

import org.springframework.stereotype.Service;

@Service
public interface MessageService <T>{
	
	void process(T object);

}
