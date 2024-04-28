package com.locdang.runnerz.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class UserRestClient {
	private final RestClient restClient;

	public UserRestClient(RestClient.Builder builder) {
		super();
//		JdkClientHttpRequestFactory jdkClientRequestFactory = new JdkClientHttpRequestFactory();
//
//		jdkClientRequestFactory.setReadTimeout(5000);
		this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
//		this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com/")
//				.requestFactory(jdkClientRequestFactory).build();
//		this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com/").requestInterceptor(null).build();
	}

	public List<User> findAll() {
		return restClient.get().uri("/users").retrieve().body(new ParameterizedTypeReference<>() {

		});
	}

	public User findById(Integer id) {
		System.out.println(id);
		return restClient.get().uri("/users/{id}", id).retrieve().body(User.class);
	}

}
