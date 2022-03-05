package com.compass.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.entities.States;
import com.compass.entities.enums.Regions;

@RestController
@RequestMapping(value = "/api/states")
public class StatesResource {

	public ResponseEntity<States> findAll() {
		States s = new States(Regions.NORDESTE, "RIO GRANDE DO NORTE", 3409000, 52797 , "Natal");
		return ResponseEntity.ok().body(s);
	}
}
