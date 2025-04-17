package disburseMyBatis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import disburseMyBatis.mapper.HouseDisburseMapper;

@Service
public class HouseDisburseDAO {
	
	@Autowired
	private HouseDisburseMapper hdm;
	
}
