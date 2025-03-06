package localhost.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PLController {
	
	public PLController(JdbcTemplate jt) {
		 String sql = "SELECT COUNT(Id) FROM POTENTIAL_LEADS";
	     int numOfRecords = jt.queryForObject(sql, Integer.class);
	     System.out.println("The number of records is: " + numOfRecords);
	     String sqlForCompanyNames = "SELECT ID, COMPANY, EMPLOYEE_COUNT FROM POTENTIAL_LEADS WHERE CITY = 'KANSAS CITY'";
	     List<Map<String, Object>> companyRecords = jt.queryForList(sqlForCompanyNames);
	     for(Map<String, Object> company : companyRecords) {
	    	 System.out.println("The Company name is: " + company.get("COMPANY"));
	    	 System.out.println("The Employee Count is: " + company.get("EMPLOYEE_COUNT"));
	    	 System.out.println();
	     }
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jt) {
		
	}

}
