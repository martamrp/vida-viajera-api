package com.marta.daw.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marta.daw.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByUsername(String username);
}