package disburseJPA.vo;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_2013Q4_HOUSE_DISBURSE")
public class HouseDisburseDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	@Column(nullable = true, name = "BIOGUIDE_ID")	
	@JsonAlias("bioGuideID")	
	private String bioguideId;
	private String office;
	private String category;
	private String payee;
	@Column(nullable = true, name = "START_DATE")	
	private String startDate;
	@Column(nullable = true, name = "END_DATE")	
	private String endDate;
	@JsonAlias("AMOUNT")
	private double amount;
	private String purpose;
	@JsonAlias("YEAR")
	private String year;
	
	
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getBioguideId() {
		return bioguideId;
	}
	public void setBioguideId(String bioguideId) {
		this.bioguideId = bioguideId;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	@Override
	public String toString() {
		return "HouseDisburseDetail [recordId=" + recordId + ", bioguideId=" + bioguideId + ", office=" + office
				+ ", category=" + category + ", payee=" + payee + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + ", year=" + year + "]";
	}
	
}
