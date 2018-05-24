package com.javerianaaes.coordinador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CoordinadorController {

	@GetMapping("/api/consultarsaldo/{userReference:[0-9]+}")
	public Factura consultarSaldo(@PathVariable("userReference") String userReference) {
		Factura factura = new Factura();
		RestTemplate restTemplate = new RestTemplate();
		String idConvenio;
		String idFactura;
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (userReference.length() == 6) {
			idConvenio = userReference.substring(0, 1);
			idFactura = userReference.substring(1, 5);
			String endpoint = restTemplate.getForObject("http://localhost:8181/enrutador/{idConvenio}", String.class,
					idConvenio);
			if (endpoint != null) {
				Map map = new HashMap();
				map.put("endpoint", endpoint);
				map.put("idFactura", idFactura);
				HttpEntity<?> entity = new HttpEntity<>(map,httpHeaders);
//				restTemplate.postForEntity(url, request, responseType)
				factura = restTemplate.postForObject("http://localhost:9191/dispatcher/consultarsaldo",entity, Factura.class);
				return factura;
			}
		}

		return factura;

	}
	
	@GetMapping("/api/pagarfactura/{userReference:[0-9]+}")
	public Response pagarFactura(@PathVariable("userReference") String userReference) {
		Response response = new Response();
		RestTemplate restTemplate = new RestTemplate();
		String idConvenio;
		String idFactura;
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (userReference.length() == 6) {
			idConvenio = userReference.substring(0, 1);
			idFactura = userReference.substring(1, 5);
			String endpoint = restTemplate.getForObject("http://localhost:8181/enrutador/{idConvenio}", String.class,
					idConvenio);
			if (endpoint != null) {
				Map map = new HashMap();
				map.put("endpoint", endpoint);
				map.put("idFactura", idFactura);
				HttpEntity<?> entity = new HttpEntity<>(map,httpHeaders);
//				restTemplate.postForEntity(url, request, responseType)
				response = restTemplate.postForObject("http://localhost:9191/dispatcher/pagarfactura",entity, Response.class);
				return response;
			}
		}

		return response;

	}
}
