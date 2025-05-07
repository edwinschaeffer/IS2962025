package disburseJPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import disburseJPA.repository.HouseDisburseRepository;
import disburseJPA.vo.HouseDisburseDetail;

@Service
public class HouseDisburseDAO {
	private HouseDisburseRepository hdr;
	
	@Autowired
	private void setJPA(HouseDisburseRepository hdr) {
		this.hdr = hdr;
	}
	
	public void insertDisburseRecords(List<HouseDisburseDetail> hdList) {
		hdr.saveAll(hdList);
	}
	
	public List<HouseDisburseDetail> getAllDataFrom2020() {
		return hdr.findByYear("2020");
	}

}
