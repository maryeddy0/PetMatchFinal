package com.petmatch.PetMatch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petmatch.PetMatch.pojosDB.User;

@Repository 
public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
}
