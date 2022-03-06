package com.compass.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.compass.entities.States;

public interface StatesRepository extends JpaRepository<States, Long> {

	Page<States> findAll(Pageable pageable);
}
