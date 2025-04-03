package localhost.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import localhost.crm.dao.HomePageDAO;
import localhost.crm.mapper.PotentialLeadMapper;
import localhost.crm.utility.CRMRestClient;
import localhost.crm.vo.PotentialLead;

@Controller
public class HomePageController {

	@Autowired
	PotentialLeadMapper plm;
	
	@Autowired
	HomePageDAO hpdao;
	
	@Autowired
	CRMRestClient crmRest;
	
	@GetMapping("/homeJSON")
	public @ResponseBody List<PotentialLead> getAllPLsJSON() {
		return plm.getAllPLs();
	}
	
	@GetMapping("/home")
	public String getAllPLs(Model m) {
		m.addAttribute("leads", plm.getAllPLs());
		return "home";
	}
	@GetMapping("/homeJPA")
	public String getAllPLsJPA(Model m) {
		m.addAttribute("leads", hpdao.getAllPLJPA());
		return "home";
	}
	@GetMapping("/homeCity")
	public String getPLsByCityJPA(@RequestParam String city, Model m) {
		m.addAttribute("leads", hpdao.getLeadByCityJPA(city));
		return "home";
	}
	
	@GetMapping("/homeZipCode/{zippy}")
	public String getPLsByZipCodeJPA(@PathVariable(value="zippy") String zip, Model m) {
		m.addAttribute("leads", hpdao.getLeadByZIPJPA(zip));
		return "home";
	}
	
	@GetMapping("/home/maxEmployees")
	public String getPLsByOfMaximumEmployees(Model m) {
		m.addAttribute("leads", hpdao.getBizzesWithMaxEmployees());
		return "home";
	}
	
	@GetMapping("/home/{plId}")
	public String getPLsByOfMaximumEmployees(@PathVariable String plId, Model m) {
		m.addAttribute("leads", hpdao.getLeadByIdBindedVariable(plId));
		return "home";
	}
	
	@GetMapping("/home/starwars")
	public void getStarWarsAPI() {
		System.out.println(crmRest.makeStarWarsAPICallout());
	}
	
	
}
