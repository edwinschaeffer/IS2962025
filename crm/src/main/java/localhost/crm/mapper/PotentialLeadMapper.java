package localhost.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import localhost.crm.vo.PotentialLead;

@Mapper
public interface PotentialLeadMapper {

	@Select("SELECT * FROM POTENTIAL_LEADS")
	@Results(id = "plResultMap", value = {
		@Result(property = "ageOfBusiness", column = "AGE_OF_BUSINESS"),
		@Result(property = "employeeCount", column = "EMPLOYEE_COUNT"),
		@Result(property = "plLeadLocationLatitude", column = "POTENTIAL_LEAD_LOCATION__LATITUDE__S"),
		@Result(property = "plLeadLocationLongitude", column = "POTENTIAL_LEAD_LOCATION__LONGITUDE__S"),
		@Result(property = "zipCode", column = "ZIP_CODE")
	})
	public List<PotentialLead> getAllPLs();
	
	@Select("SELECT * FROM POTENTIAL_LEADS WHERE ID = #{id}")
	@ResultMap("plResultMap")
	public PotentialLead getLeadById(String id);
	
}
