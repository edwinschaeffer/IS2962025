package localhost.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import localhost.crm.mapper.PotentialLeadMapper;
import localhost.crm.vo.PotentialLead;

@Controller
public class HomePageController {

	@Autowired
	PotentialLeadMapper plm;
	
	@GetMapping("/homeJSON")
	public @ResponseBody List<PotentialLead> getAllPLsJSON() {
		return plm.getAllPLs();
	}
	
	@GetMapping("/home")
	public String getAllPLs(Model m) {
		m.addAttribute("leads", plm.getAllPLs());
		return "home";
	}
}
