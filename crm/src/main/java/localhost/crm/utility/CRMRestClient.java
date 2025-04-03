package localhost.crm.utility;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CRMRestClient {

	public String makeStarWarsAPICallout() {
		RestClient restClient = RestClient.create();
		String result = restClient.get()
				.uri("https://swapi.dev/api/starships/5/")
				.retrieve()
				.body(String.class);
				return result;
				
	}
}
