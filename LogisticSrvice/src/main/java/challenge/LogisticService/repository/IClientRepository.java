package challenge.LogisticService.repository;

import org.springframework.data.repository.CrudRepository;

import challenge.commons.models.Client;

public interface IClientRepository extends CrudRepository<Client, String> {

}
