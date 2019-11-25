package com.marta.daw.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marta.daw.project.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
