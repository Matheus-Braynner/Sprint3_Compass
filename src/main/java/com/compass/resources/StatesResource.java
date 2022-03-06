package com.compass.resources;


import java.net.URI;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compass.entities.States;
import com.compass.repositories.StatesRepository;
import com.compass.resources.dto.StatesDto;
import com.compass.services.StatesService;

@RestController
@RequestMapping(value = "/api/states")
public class StatesResource {

	@Autowired
	private StatesService statesService;
	
	@Autowired
	private StatesRepository statesRepository;

	@GetMapping
	public Page<StatesDto> findAll(@PageableDefault(sort = {"regions" , "population", "area"} 
	, direction = Direction.DESC, page = 0, size = 10) Pageable pagination) {
		
		Page<States> list = statesRepository.findAll(pagination);
		return StatesDto.convert(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<States> findById(@PathVariable Long id) {
		States obj = statesService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<States> insert(@RequestBody States obj) {
		obj = statesService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		statesService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<States> update(@PathVariable Long id, @RequestBody States obj) {
		obj = statesService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
