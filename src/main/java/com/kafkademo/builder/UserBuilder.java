package com.kafkademo.builder;

import org.springframework.stereotype.Component;

import com.kafkademo.model.User;

@Component
public class UserBuilder {

	public static User build(String name, Integer age) {
		return User.builder().name(name).age(age).build();
	}
}
