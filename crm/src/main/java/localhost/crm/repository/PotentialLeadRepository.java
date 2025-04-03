package localhost.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import localhost.crm.vo.PotentialLead;

public interface PotentialLeadRepository extends JpaRepository<PotentialLead, String> {

	// findByXX generates the query 
	// "SELECT * FROM POTENTIAL_LEADS WHERE XX = 'myParameter'
	List<PotentialLead> findByCity(String city);
	List<PotentialLead> findByZipCode(String zipCode);
	
	@Query(value = "SELECT * FROM POTENTIAL_LEADS "
                 + "WHERE EMPLOYEE_COUNT=(SELECT MAX(EMPLOYEE_COUNT) "
                 + "FROM POTENTIAL_LEADS)", nativeQuery=true)
	List<PotentialLead> getMaxEmployees();
	
	@Query(value = "SELECT * FROM POTENTIAL_LEADS " + 
	               "WHERE ID =:plId", nativeQuery = true)
	// if the String variable was named plId, @Param would not be needed.
	List<PotentialLead> getLeadsById(@Param("plId") String potentialLeadId);
	
}
