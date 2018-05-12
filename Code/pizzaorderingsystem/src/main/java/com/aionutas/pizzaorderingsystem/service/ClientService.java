package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Client;
import com.aionutas.pizzaorderingsystem.model.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = ClientRepo.class)
@Configuration
public class ClientService {

    @Autowired
    ClientRepo clientRepo;

    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    public Optional<Client> getById(Long id) {
        return clientRepo.findById(id);
    }

    public void deleteClient(Long id) {
        Client deleteClient = clientRepo.findById(id).get();

        if (deleteClient.getId() != null) {
            clientRepo.delete(deleteClient);
        } else {
            System.out.println("Could not delete client!");
        }

    }

    public List<Client> findAllClients() {
        return clientRepo.findAll();
    }

    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }
}
