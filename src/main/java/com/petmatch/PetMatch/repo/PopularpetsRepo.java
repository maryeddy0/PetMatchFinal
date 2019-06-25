package com.petmatch.PetMatch.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petmatch.PetMatch.entities.Popularpets;

public interface PopularpetsRepo extends JpaRepository <Popularpets, Integer> {

}
