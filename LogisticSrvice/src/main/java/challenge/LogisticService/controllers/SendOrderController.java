package challenge.LogisticService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.LogisticService.services.IClientService;
import challenge.commons.models.Client;


/**
 * This class creates the order in the database
 * @author Alejandro Giraldo
 *
 */
@RestController
@RequestMapping(value="/Logistic")
public class SendOrderController {
	
	@Autowired
	private IClientService clientService;
	
	/**
	 * In this method is the service call to create the register in the database
	 * @param client
	 * @return
	 */
	@PostMapping(value="/sendOrder")
	public Client SendOrder(@RequestBody Client client) {
		
		System.out.println("client of Logistic service " + client);
		
		Client newClient = null;
		newClient = clientService.save(client);
		return newClient;
		
	}
}
