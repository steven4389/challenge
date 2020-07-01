package challenge.LogisticService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.LogisticService.repository.IClientRepository;
import challenge.commons.models.Client;


@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientRepository clientRepository;
	
	@Override
	public Client save(Client client) {
		clientRepository.save(client);
		return client;
	}

}
