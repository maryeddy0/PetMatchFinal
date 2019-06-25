package com.petmatch.PetMatch.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petmatch.PetMatch.pojosDB.History;

@Repository
public interface HistoryRepo extends JpaRepository<History, Integer> {
	
	List<History> findByUserid(Integer userid);
	
}
