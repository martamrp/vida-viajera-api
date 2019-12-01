package com.marta.daw.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marta.daw.project.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

	List<Trip> findByUserId(int userId);
	List<Trip> findByReasonId(int reasonId);
	boolean existsByOriginAndDestinationAndStartDateAndEndDateAndUserId(String origin, String destination, Date startDate, Date endDate, int userId);
	Trip findTopByUserIdOrderByPriceAsc(int userId);
	Trip findTopByUserIdOrderByPriceDesc(int userId);
	List<Trip> findByUserIdAndReasonId(int userId, int reasonId);
		
	@Query("SELECT t FROM Trip t WHERE t.userId = ?1 ORDER BY DATEDIFF(t.endDate, t.startDate) ASC")
	List<Trip> findTripsByUserIdOrderByDurationAsc(int userId);
	
	@Query("SELECT t FROM Trip t WHERE t.userId = ?1 ORDER BY DATEDIFF(t.endDate, t.startDate) DESC")
	List<Trip> findTripsByUserIdOrderByDurationDesc(int userId);
	
	@Query("SELECT t FROM Trip t WHERE t.userId = ?1 ORDER BY t.price/(DATEDIFF(t.endDate, t.startDate)+1) ASC")
	List<Trip> findTripsByUserIdOrderByPricePerDayAsc(int userId);
	
	@Query("SELECT t FROM Trip t WHERE t.userId = ?1 ORDER BY t.price/(DATEDIFF(t.endDate, t.startDate)+1) DESC")
	List<Trip> findTripsByUserIdOrderByPricePerDayDesc(int userId);

	/*
	@Query("SELECT YEAR(startDate) AS year, count(id) as trips " + 
			"FROM Trip " + 
			"GROUP BY year, UserId " + 
			"HAVING userId=?1 " + 
			"ORDER BY trips DESC " + 
			"LIMIT 1")
	int findYear(int userId);*/
}
