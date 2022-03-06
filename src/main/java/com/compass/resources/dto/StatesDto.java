package com.compass.resources.dto;

import org.springframework.data.domain.Page;


import com.compass.entities.States;
import com.compass.entities.enums.Regions;

public class StatesDto {
	
	private Long id;
	private Regions regions;
	private String name;
	private Integer population;
	private Integer area;
	private String capital;
	
	public StatesDto() {
		
	}

	public StatesDto(States states) {
		this.id = states.getId();
		this.regions = states.getRegions();
		this.name = states.getName();
		this.population = states.getPopulation();
		this.area = states.getArea();
		this.capital = states.getCapital();
	}

	public Long getId() {
		return id;
	}

	public Regions getRegions() {
		return regions;
	}

	public String getName() {
		return name;
	}

	public Integer getPopulation() {
		return population;
	}

	public Integer getArea() {
		return area;
	}

	public String getCapital() {
		return capital;
	}
	
	public static Page<StatesDto> convert(Page<States> states) {
		return states.map(StatesDto::new);
	}
	

}
