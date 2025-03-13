package localhost.crm.vo;

public class PotentialLead {
	private String id; 
	private String ageOfBusiness;
	private String city;
	private String company;
	private String country;
	private String area;
	private String employeeCount;
	private String industry;
	private String phone;
	private String plLeadLocationLatitude;
	private String plLeadLocationLongitude;
	private String sector;
	private String state;
	private String status;
	private String street;
	private String website;
	private String zipCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAgeOfBusiness() {
		return ageOfBusiness;
	}
	public void setAgeOfBusiness(String ageOfBusiness) {
		this.ageOfBusiness = ageOfBusiness;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPlLeadLocationLatitude() {
		return plLeadLocationLatitude;
	}
	public void setPlLeadLocationLatitude(String plLeadLocationLatitude) {
		this.plLeadLocationLatitude = plLeadLocationLatitude;
	}
	public String getPlLeadLocationLongitude() {
		return plLeadLocationLongitude;
	}
	public void setPlLeadLocationLongitude(String plLeadLocationLongitude) {
		this.plLeadLocationLongitude = plLeadLocationLongitude;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "PotentialLead [id=" + id + ", ageOfBusiness=" + ageOfBusiness + ", city=" + city + ", company="
				+ company + ", country=" + country + ", area=" + area + ", employeeCount=" + employeeCount
				+ ", industry=" + industry + ", phone=" + phone + ", plLeadLocationLatitude=" + plLeadLocationLatitude
				+ ", plLeadLocationLongitude=" + plLeadLocationLongitude + ", sector=" + sector + ", state=" + state
				+ ", status=" + status + ", street=" + street + ", website=" + website + ", zipCode=" + zipCode + "]";
	}
	
}
