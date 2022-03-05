package com.compass.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.entities.States;
import com.compass.repositories.StatesRepository;

@Service
public class StatesService {

	@Autowired
	private StatesRepository statesRepository;

	public List<States> findAll() {
		return statesRepository.findAll();
	}

	public States findById(Long id) {
		Optional<States> obj = statesRepository.findById(id);
		return obj.get();
	}
	
	public States insert (States obj) {
		return statesRepository.save(obj);
	}
	
	public void delete (Long id) {
		statesRepository.deleteById(id);
	}
	
	public States update(Long id, States obj) {
		States entity = statesRepository.getById(id);
		updateData(entity, obj);
		return statesRepository.save(entity);
	}

	private void updateData(States entity, States obj) {
		entity.setRegions(obj.getRegions());
		entity.setName(obj.getName());
		entity.setArea(obj.getArea());
		entity.setPopulation(obj.getPopulation());
		entity.setCapital(obj.getCapital());
		
	}
}
