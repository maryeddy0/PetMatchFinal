package com.petmatch.PetMatch.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petmatch.PetMatch.pojos.PetTable;

public interface PetsRepo extends JpaRepository <PetTable, Integer> {

	
	
	
}
