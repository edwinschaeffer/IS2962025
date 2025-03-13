package localhost.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import localhost.crm.mapper.PotentialLeadMapper;
import localhost.crm.vo.PotentialLead;

@Component
public class PLController {
	/*
	We decided to use Constructor injection, but if we didn't want
	to do that, we could've used the below code and got the same result.
	
	@Autowired
	PotentialLeadMapper plm; */
	
	public PLController(JdbcTemplate jt, PotentialLeadMapper plm) {
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
	     List<PotentialLead> plList = plm.getAllPLs();
	     for(PotentialLead pl : plList) {
	    	 System.out.println(" The Id is: " + pl.getId());
	    	 System.out.println("The entire record is: ");
	    	 System.out.println(pl.toString());
	     }
	     PotentialLead pl = plm.getLeadById("PL-140143");
	     System.out.println("The guy that arrested me took me here: " + pl.getStreet());
	}
	// Auto Wire with setter injection. 
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jt) {
		
	}

}
