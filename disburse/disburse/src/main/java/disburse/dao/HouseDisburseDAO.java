package disburse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HouseDisburseDAO {
	private JdbcTemplate jdbcT;
		
	@Autowired
	public HouseDisburseDAO(JdbcTemplate jdbcT) {
		this.jdbcT = jdbcT;
	}

}
