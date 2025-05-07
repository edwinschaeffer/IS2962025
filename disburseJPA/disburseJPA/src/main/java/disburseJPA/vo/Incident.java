package disburseJPA.vo;

public class Incident {
	private String short_description;
	private int urgency;
	private int state;
	
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public int getUrgency() {
		return urgency;
	}
	public void setUrgency(int urgency) {
		this.urgency = urgency;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
