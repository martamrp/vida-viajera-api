package com.marta.daw.project.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

	//Trip findByUserId(int userId);
	//@Query("SELECT id, startDate, origin, destination FROM trip WHERE userId = :userId")
	List<Trip> findByUserId(int userId);
	
	//List<Trip> findById(int id);
}
