package com.kafkademo.kafkaconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@EnableKafka
@Configuration
public class KafkaConsumerConfig<T> extends KafkaConfig<T>{
	
	private static final String GROUP_ID = "group_id";
	
	@Bean
	public ConsumerFactory<String, T> buildConsumerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST); 
		config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, T>(config, 
				new StringDeserializer(), 
				new JsonDeserializer<>(Object.class, false));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,T> concurrentKafkaListenerContainer(){
		ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<String, T>();
		factory.setConsumerFactory(buildConsumerFactory());
		return factory;
	}
	
}
