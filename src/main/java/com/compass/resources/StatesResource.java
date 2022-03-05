package com.compass.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.entities.States;
import com.compass.services.StatesService;

@RestController
@RequestMapping(value = "/api/states")
public class StatesResource {

	@Autowired
	private StatesService statesService;

	@GetMapping
	public ResponseEntity<List<States>> findAll() {
		List<States> list = statesService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<States> findById(@PathVariable Long id) {
		States obj = statesService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
