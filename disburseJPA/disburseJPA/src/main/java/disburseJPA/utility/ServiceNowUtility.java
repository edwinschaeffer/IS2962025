package disburseJPA.utility;

import java.util.Base64;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import disburseJPA.vo.Incident;

@Service
public class ServiceNowUtility {
	
	public String postIncident(String short_description) {
		Incident i = new Incident();
		i.setShort_description(short_description);
		i.setUrgency(3);
		i.setState(1);

		String encodedString = Base64.getEncoder().encodeToString(("admin" + ":" + "Gi26*uX/RusD").getBytes());
		
		RestClient restClient = RestClient.create();
		ResponseEntity<String> responseEntity = restClient
				.post().uri("https://dev269614.service-now.com/api/now/table/incident?sysparm_fields=number")
				.header("Accept", "application/json")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Basic "+ encodedString)
				.body(i)
				.retrieve()
				.toEntity(String.class);
		return responseEntity.getBody();
		
	}
}
