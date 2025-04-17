package disburseJPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import disburseJPA.dao.HouseDisburseDAO;

@Controller
public class HouseDisburseController {

	@Autowired
	private HouseDisburseDAO hdo;
}
