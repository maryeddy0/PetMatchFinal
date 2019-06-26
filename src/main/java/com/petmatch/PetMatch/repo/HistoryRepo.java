package com.petmatch.PetMatch.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petmatch.PetMatch.pojosDB.History;

@Repository
public interface HistoryRepo extends JpaRepository<History, Integer> {
	History findByPetID(Integer petID);
	List<History> findByUserid(Integer userid); //select h from History h where h = the userid.
	
}
