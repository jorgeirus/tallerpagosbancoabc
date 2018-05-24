package config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrutadorController {
	
	@Autowired
	private RoutingService routingService;
	
	@GetMapping("/services")
	public List<Rouiting> findAll(){
		return routingService.loadRoutings();
	}
	
	@GetMapping("/enrutador/{idConvenio}")
	public String findService(@PathVariable("idConvenio") String idConvenio){
		List<Rouiting> routingServices = routingService.loadRoutings();
		Rouiting rouiting = routingServices.stream().filter(p->p.getIdConvenio().equals(idConvenio)).findAny().orElse(null);
		return rouiting.getEndpoint();
	}

    @GetMapping("/")
    public String greeting() {
        return "Bienvenido al Microservicio enrrutamiento";
    }
}
