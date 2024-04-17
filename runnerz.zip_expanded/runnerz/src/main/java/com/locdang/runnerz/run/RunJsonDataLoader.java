package com.locdang.runnerz.run;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);

	private final JdbcClientRunRepository runRepository;
	private final ObjectMapper objectMapper;

	public RunJsonDataLoader(JdbcClientRunRepository runRepository, ObjectMapper objectMapper) {
		super();
		this.runRepository = runRepository;
		this.objectMapper = objectMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if (runRepository.count() <= 0) {
			try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
				Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
				log.info("Reading {} runs from JSON data and saving to in-memory collection.", allRuns.runs().size());
				runRepository.saveAll(allRuns.runs());
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("Failed to read JSON data", e);
			}
		} else {
			log.info("Not loading Runs from JSON data because the collection contrains data.");
		}
	}

}
