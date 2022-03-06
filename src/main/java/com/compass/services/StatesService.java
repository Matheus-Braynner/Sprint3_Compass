package com.compass.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compass.entities.States;
import com.compass.repositories.StatesRepository;
import com.compass.services.exceptions.DatabaseException;
import com.compass.services.exceptions.ResourceNotFoundException;

@Service
public class StatesService {

	@Autowired
	private StatesRepository statesRepository;

	public List<States> findAll(Pageable pageable) {
		return statesRepository.findAll();
	}

	public States findById(Long id) {
		Optional<States> obj = statesRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public States insert (States obj) {
		return statesRepository.save(obj);
	}
	
	public void delete (Long id) {
		try {
			statesRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public States update(Long id, States obj) {
		try {
			States entity = statesRepository.getById(id);
			updateData(entity, obj);
			return statesRepository.save(entity);
		} catch (EntityNotFoundException e) {	
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(States entity, States obj) {
		entity.setRegions(obj.getRegions());
		entity.setName(obj.getName());
		entity.setArea(obj.getArea());
		entity.setPopulation(obj.getPopulation());
		entity.setCapital(obj.getCapital());
		
	}

}
