package disburseJPA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import disburseJPA.repository.HouseDisburseRepository;

@Service
public class HouseDisburseDAO {
	private HouseDisburseRepository hdr;
	
	@Autowired
	private void setJPA(HouseDisburseRepository hdr) {
		this.hdr = hdr;
	}

}
