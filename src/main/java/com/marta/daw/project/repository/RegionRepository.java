package com.marta.daw.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marta.daw.project.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>  {
	@Query("SELECT DISTINCT r " + 
			"FROM Trip t " + 
			"	JOIN Country c ON t.originCountry = c.code OR t.destinationCountry = c.code " + 
			"   JOIN Region r ON r.id = c.regionId " + 
			"WHERE t.userId = ?1")
	List<Region> findRegionsByUserId(int userId);
}
