package disburseMyBatis.vo;

public class HouseDisburseDetail {
	private int recordId;
	private String bioguideId;
	private String office;
	private String category;
	private String payee;
	private String startDate;
	private String endDate;
	private double amount;
	private String year;
	private String purpose;
	
	
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
