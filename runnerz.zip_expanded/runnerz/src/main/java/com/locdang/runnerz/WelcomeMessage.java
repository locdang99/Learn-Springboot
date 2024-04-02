package com.locdang.runnerz;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
	public String getWelcomeMessage() {
		return "Welcome to the Spring Boot Application with Loc Dang!";
	}
}
