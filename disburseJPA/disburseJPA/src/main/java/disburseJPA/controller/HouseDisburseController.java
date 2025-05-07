package disburseJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import disburseJPA.dao.HouseDisburseDAO;
import disburseJPA.utility.ServiceNowUtility;
import disburseJPA.vo.HouseDisburseDetail;

@Controller
public class HouseDisburseController {

	@Autowired
	private HouseDisburseDAO hdo;
	
	@Autowired
	private ServiceNowUtility snow;
	
	@GetMapping("/incident")
	public String getIncidentPage() {
		return "createIncident";
	}
	
	@PostMapping("/loadDisburse")
	public @ResponseBody List<HouseDisburseDetail> postDisburse(@RequestBody List<HouseDisburseDetail> hdList) {
		hdo.insertDisburseRecords(hdList);
		return hdo.getAllDataFrom2020();
	}
	@PostMapping("/submitIncident")
	public @ResponseBody String consumeIncident(@RequestParam String incidentText) {
		return snow.postIncident(incidentText);
	}
}
