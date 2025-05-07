package disburseMyBatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import disburseMyBatis.dao.HouseDisburseDAO;
import disburseMyBatis.vo.HouseDisburseDetail;

@Controller
public class HouseDisburseController {

	@Autowired
	private HouseDisburseDAO hdo;
	
	@GetMapping("/highestAmount")
	private String getHighestAmount(Model m) {
		List<HouseDisburseDetail> hdList = hdo.getHighestAmount();
		m.addAttribute("hdList", hdList);
		return "disburse";
	}
}
