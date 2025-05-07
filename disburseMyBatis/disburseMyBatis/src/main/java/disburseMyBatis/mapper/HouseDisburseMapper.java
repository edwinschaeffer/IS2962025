package disburseMyBatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;

import disburseMyBatis.vo.HouseDisburseDetail;

@Mapper
public interface HouseDisburseMapper {
	@Select("SELECT * from T_2013Q4_HOUSE_DISBURSE where AMOUNT = (SELECT MAX(AMOUNT) from T_2013Q4_HOUSE_DISBURSE)")
	@Results(id = "hdResultMap", value = {
		@Result(property = "startDate", column = "START_DATE"),
		@Result(property = "endDate", column = "END_DATE"),
	})
	public List<HouseDisburseDetail> getHighestAmount();

}
