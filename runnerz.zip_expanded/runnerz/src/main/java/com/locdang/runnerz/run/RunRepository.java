package com.locdang.runnerz.run;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface RunRepository extends ListCrudRepository<Run, Integer>{
	@Query("SELECT * FROM Run WHERE location = :location")
	List<Run> findAllByLocation(String location);
}
