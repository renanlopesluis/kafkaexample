package com.kafkademo.kafkaconfig;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.kafkademo.model.User;

@Configuration
public class UserKafkaConfig extends KafkaConsumerConfig<User>{
	
	@Bean
	public ConsumerFactory<String, User> consumerFactory(){
		Map<String, Object> config = kafkaProps();
		config.put(ConsumerConfig.GROUP_ID_CONFIG, USER_GROUP_ID);
		return new DefaultKafkaConsumerFactory<String, User>(config, 
				new StringDeserializer(), 
				new JsonDeserializer<>(User.class, false));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,User> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
