package localhost.crm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import localhost.crm.repository.PotentialLeadRepository;
import localhost.crm.vo.PotentialLead;

@Service
public class HomePageDAO {
	
	@Autowired
	private PotentialLeadRepository plRepo;
	
	public List<PotentialLead> getAllPLJPA() {
		return plRepo.findAll();
	}
	
	public List<PotentialLead> getLeadByCityJPA(String city) {
		return plRepo.findByCity(city.toUpperCase());
	}

	public List<PotentialLead> getLeadByZIPJPA(String zip) {
		return plRepo.findByZipCode(zip);
	}
	
	public List<PotentialLead> getBizzesWithMaxEmployees() {
		return plRepo.getMaxEmployees();
	}
	
	public List<PotentialLead> getLeadByIdBindedVariable(String id) {
		return plRepo.getLeadsById(id);
	}
}
