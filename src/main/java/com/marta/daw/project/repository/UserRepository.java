package com.marta.daw.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marta.daw.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findFirstByUsername(String username);
}
