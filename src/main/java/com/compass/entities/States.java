package com.compass.entities;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.compass.entities.enums.Regions;

@Entity
public class States implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Regions regions;
	private String name;
	private Integer population;
	private Integer area;
	private String capital;
	
	public States() {
		
	}
	
	public States(Long id, Regions regions, String name, Integer population, Integer area, String capital) {
		this.id = id;
		this.regions = regions;
		this.name = name;
		this.population = population;
		this.area = area;
		this.capital = capital;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Regions getRegions() {
		return regions;
	}
	
	public void setRegions(Regions regions) {
		this.regions = regions;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPopulation() {
		return population;
	}
	
	public void setPopulation(Integer population) {
		this.population = population;
	}
	
	public Integer getArea() {
		return area;
	}
	
	public void setArea(Integer area) {
		this.area = area;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		States other = (States) obj;
		return Objects.equals(id, other.id);
	}
}
