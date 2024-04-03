package com.locdang.runnerz.run;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

	@GetMapping("/{id}")
	Run findById(@PathVariable Integer id) {
		Optional<Run> run = runRepository.findById(id);
		if (run.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return run.get();
	}

	// Post
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	void create(@RequestBody Run run) {
		runRepository.create(run);
	}

	// Put
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@RequestBody Run run, @PathVariable Integer id) {
		runRepository.update(run, id);
		;
	}

	// Delete
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void delete(@PathVariable Integer id) {
		runRepository.delete(id);
		;
	}
}
