package com.locdang.runnerz.run;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/runs")
public class RunController {

	private final RunRepository runRepository;

	public RunController(RunRepository runRepository) {
		this.runRepository = runRepository;
	}

//	@RequestMapping("/")
//	String home() {
//		return "Hello World!";
//	}

	@GetMapping("/hello")
	String homeNew() {
		return "Hello, Runnerz";
	}

	@GetMapping("/")
	List<Run> findAll() {
		return runRepository.findAll();
	}
	
	@GetMapping("/1")
	Run findById() {
		return null;
	}
}
