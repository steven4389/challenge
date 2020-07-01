package challenge.CheckoutService.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import challenge.commons.models.Client;
import challenge.commons.models.Product;




/**
 * this class call two services, the billService and LogisticService
 * @author Alejandro Giraldo
 *
 */
@RestController
@RequestMapping(value="/order")
public class OrderController {
	
	/**
	 * 
	 * @param client. In this parameter the customer enters together with the products to be calculated
	 * @return Return the order
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping(value="/createOrder")
	public ResponseEntity<?> createOrder(@RequestBody Client client) {
		
		Map<String, Object> response = new HashMap<>();
		Stack<Long> costAndQuantity = new Stack<Long>();
		ResponseEntity<Client> resultCallServiceLogisticService= null;
	
		try {
			System.out.println("Order " + client.toString());
			
			List<Product> products = new ArrayList<Product>();
			
			products= client.getProducts();
			
			for(Product p: products ) {
				costAndQuantity.push(p.getCost()*p.getQuantity());
			}
			System.out.println("costAndQuantity"+costAndQuantity);
			
			/**
			 * Here is the call to service that adds the products
			 */
			RestTemplate restTemplate = new RestTemplate();
			Long l = restTemplate.postForObject("http://localhost:8001/sumService/sum", costAndQuantity, Long.class);
			
			client.setTotal(l);
			
			/**
			 * Here is the call to service that generate the order
			 */
			RestTemplate restTemplateLogisticService = new RestTemplate();
		     HttpHeaders headersLogisticService=new HttpHeaders();
		     headersLogisticService.set("Content-Type", "application/json");

			@SuppressWarnings("unchecked")
			HttpEntity<Client> requestEntityLogisticService=new HttpEntity(client, headersLogisticService);

			resultCallServiceLogisticService = restTemplateLogisticService.exchange("http://localhost:8002/Logistic/sendOrder", HttpMethod.POST,requestEntityLogisticService,Client.class);
			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "The order was created successfully!");
		response.put("message", resultCallServiceLogisticService);
		response.put("message", resultCallServiceLogisticService);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
