package localhost.crm;

import org.springframework.boot.SpringApplication;

import config.CRMConfig;
import localhost.crm.controller.PLController;


public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CRMConfig.class, args);
	}

}
