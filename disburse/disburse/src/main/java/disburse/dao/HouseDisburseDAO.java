package disburse.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import disburse.vo.HouseDisburseDetail;

@Service
public class HouseDisburseDAO {
	private JdbcTemplate jdbcT;
		
	@Autowired
	public HouseDisburseDAO(JdbcTemplate jdbcT) {
		this.jdbcT = jdbcT;
	}
	
	public List<HouseDisburseDetail> getAllData() {
		List<HouseDisburseDetail> hdDetailAll = jdbcT.query("SELECT RECORDID, BIOGUIDE_ID as bioguideId, OFFICE, CATEGORY,"
				+ "PAYEE, START_DATE as startDate, END_DATE as endDate, PURPOSE, AMOUNT, YEAR FROM"
				+ " T_2013Q4_HOUSE_DISBURSE", new BeanPropertyRowMapper(HouseDisburseDetail.class));
		for(HouseDisburseDetail hd : hdDetailAll) {
			hd.setOffice( hd.getOffice().toLowerCase() );
		}
		return hdDetailAll;
	}
	
	public List<HouseDisburseDetail> getAllDataFrom2020() {
		List<HouseDisburseDetail> hdDetail2020 = jdbcT.query("SELECT RECORDID, BIOGUIDE_ID as bioguideId, OFFICE, CATEGORY,"
				+ "PAYEE, START_DATE as startDate, END_DATE as endDate, PURPOSE, AMOUNT, YEAR FROM"
				+ " T_2013Q4_HOUSE_DISBURSE "
				+ " WHERE YEAR='2020'", new BeanPropertyRowMapper(HouseDisburseDetail.class));	
		return hdDetail2020;
	}
	
	public void insertDisburseRecords(List<HouseDisburseDetail> hdList) {
		String sql = 
				"INSERT INTO T_2013Q4_HOUSE_DISBURSE "
				   + "(BIOGUIDE_ID, OFFICE, CATEGORY, PAYEE, START_DATE, END_DATE, "
				   + " PURPOSE, AMOUNT, YEAR) "
		      + "VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcT.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, hdList.get(i).getBioguideId());
                ps.setString(2, hdList.get(i).getOffice());
                ps.setString(3, hdList.get(i).getCategory());
                ps.setString(4, hdList.get(i).getPayee());
                ps.setString(5, hdList.get(i).getStartDate());
                ps.setString(6, hdList.get(i).getEndDate());
                ps.setString(7, hdList.get(i).getPurpose());
                ps.setDouble(8, hdList.get(i).getAmount());
                ps.setString(9, hdList.get(i).getYear());
                System.out.println(hdList.get(i).getYear());
            }

            @Override
            public int getBatchSize() {
                return hdList.size();
            }
        });
	}
	
	public List<HouseDisburseDetail> getChangeCategory() {
		List<HouseDisburseDetail> hdList = getAllData();
		for(HouseDisburseDetail hd : hdList) {
			switch (hd.getCategory()) {
				case "TRAVEL":
					hd.setCategory("T");
					break;
				case "FRANKED MAIL":
					hd.setCategory("FM");
					break;
				case "PERSONNEL COMPENSATION":
					hd.setCategory("PC");
					break;
				case "RENT":
					hd.setCategory("R");
					break;
				case "EQUIPMENT":
					hd.setCategory("E");
					break;
				case "OTHER SERVICES":
					hd.setCategory("OS");
					break;
				case "SUPPLIES AND MATERIALS":
					hd.setCategory("SM");
					break;
				case "PRINTING AND REPRODUCTION":
					hd.setCategory("PR");
					break;
			}
		}
		String sql = 
				"UPDATE T_2013Q4_HOUSE_DISBURSE "
		          + "SET CATEGORY = ? " +
				    "WHERE RECORDID = ?";
		jdbcT.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, hdList.get(i).getCategory());
                ps.setLong(2, hdList.get(i).getRecordId());
            }

            @Override
            public int getBatchSize() {
                return hdList.size();
            }
        });
		return getAllData();
	}

}
