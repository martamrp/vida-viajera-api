package com.marta.daw.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marta.daw.project.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

	List<Trip> findByUserId(int userId);
	List<Trip> findByReasonId(int reasonId);
	boolean existsByOriginAndDestinationAndStartDateAndEndDateAndUserId(String origin, String destination, Date startDate, Date endDate, int userId);
	Trip findTopByUserIdOrderByPriceAsc(int userId);
	Trip findTopByUserIdOrderByPriceDesc(int userId);

}
