package disburse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import disburse.dao.HouseDisburseDAO;
import disburse.vo.HouseDisburseDetail;

@Controller
public class HouseDisburseController {

	@Autowired
	private HouseDisburseDAO hdo;
	
	@GetMapping("/all")
	private String getAllData(Model m) {
		List<HouseDisburseDetail> hdList = hdo.getAllData();
		m.addAttribute("hdList", hdList);
		return "disburse";
	}
	
	@PostMapping("/loadDisburse")
	public @ResponseBody List<HouseDisburseDetail> postDisburse(@RequestBody List<HouseDisburseDetail> hdList) {
		hdo.insertDisburseRecords(hdList);
		return hdo.getAllDataFrom2020();
	}
	
	@GetMapping("/changeCategory")
	private String getChangeCategory(Model m) {
		List<HouseDisburseDetail> hdList = hdo.getChangeCategory();
		m.addAttribute("hdList", hdList);
		return "disburse";
	}
	
}
