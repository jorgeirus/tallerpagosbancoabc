package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoutingService {
	
	public List<Rouiting> loadRoutings(){
		List<Rouiting> rouitings = new ArrayList<>();
		Rouiting rouiting1 = new Rouiting("1","http://localhost:9090/servicios/pagos/v1/payments","REST");
		Rouiting rouiting2 = new Rouiting("2","http://luz", "SOAP");
		rouitings.add(rouiting1);
		rouitings.add(rouiting2);
		return rouitings;
	}
	
	

}
