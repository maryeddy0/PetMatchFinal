package com.petmatch.PetMatch.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petmatch.PetMatch.pojosDB.PetTable;


@Repository
public interface PetsRepo extends JpaRepository<PetTable, Integer> {
	//get all keywords from database
	@Query("select keywords from PetTable p")
	List<String> getKeywords();
	
	//get all petTypes from database
	@Query("select petType from PetTable p")
	List<String> getType();
}
