package com.petmatch.PetMatch.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petmatch.PetMatch.pojosDB.History;


@Repository //tells spring to capture the domain class to work with... 
public interface HistoryRepo extends JpaRepository<History, Integer> { //domine class and id typeS
	History findByPetID(Integer petID);
	List<History> findByUserid(Integer userid); //select h from History h where h = the userid.
	
}



/** Alt+shift+J
 * @author Linmei
 *@repository is the persistence layer that is responsible for offering data access operations to the service layer(@Service)
 *@Service is the service layer that is encapsulates the business logic and computations for application.
 *@Controller is the presentation layer that 
 *
 */