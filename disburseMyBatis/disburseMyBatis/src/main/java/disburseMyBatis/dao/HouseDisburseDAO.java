package disburseMyBatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import disburseMyBatis.mapper.HouseDisburseMapper;
import disburseMyBatis.vo.HouseDisburseDetail;

@Service
public class HouseDisburseDAO {
	
	@Autowired
	private HouseDisburseMapper hdm;
	
	public List<HouseDisburseDetail> getHighestAmount() {
		return hdm.getHighestAmount();
	}
	
}
