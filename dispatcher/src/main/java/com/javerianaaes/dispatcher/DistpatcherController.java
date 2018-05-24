package com.javerianaaes.dispatcher;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class DistpatcherController {

	@PostMapping(path = "/dispatcher/consultarsaldo")
	public Factura consultarsaldo(@RequestBody Factura factura) {
		RestTemplate restTemplate = new RestTemplate();
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
			if (factura != null) {
//				restTemplate.postForEntity(url, request, responseType)
				int idFactura = factura.getIdFactura();
				factura = restTemplate.getForObject(factura.getEndpoint() + "/{idFactura}", Factura.class, idFactura);
				return factura;
			}

		return factura;
	}
	
	@PostMapping(path="/dispatcher/pagarfactura", produces="application/json")
	public Response pagarFactura(@RequestBody Factura factura){
		Response response = new Response();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
			if (factura != null) {
//				restTemplate.postForEntity(url, request, responseType)
				int idFactura = factura.getIdFactura();
				response = restTemplate.postForObject(factura.getEndpoint() + "/{idFactura}", entity, Response.class, idFactura);
				return response;
			}

		return response;
	}

}
